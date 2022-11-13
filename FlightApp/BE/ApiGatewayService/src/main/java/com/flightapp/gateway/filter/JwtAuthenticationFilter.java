package com.flightapp.gateway.filter;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.flightapp.gateway.util.JwtUtil;

import io.jsonwebtoken.Claims;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {
   public JwtAuthenticationFilter() {
         super(Config.class);
    }

   @Autowired
   private JwtUtil jwtUtil;
   
   @Override
   public GatewayFilter apply(Config config) {
	return (exchange, chain) -> {
		ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
		final List<String> apiEndpoints = List.of("/register", "/login");

		Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
				.noneMatch(uri -> r.getURI().getPath().contains(uri));
		if (isApiSecured.test(request)) {
			if (!request.getHeaders().containsKey("Authorization")) {
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);

				return response.setComplete();
			}

			final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

			try {
				jwtUtil.validateToken(token);
			} catch (Exception e) {
				// e.printStackTrace();

				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.BAD_REQUEST);

				return response.setComplete();
			}

			Claims claims = jwtUtil.getClaims(token);
			exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
		}
		return chain.filter(exchange);
	    };
    }

    public static class Config {
	 // Put the configuration properties
    }
}