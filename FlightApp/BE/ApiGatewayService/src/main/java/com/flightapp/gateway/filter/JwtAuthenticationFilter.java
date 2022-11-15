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
import org.springframework.web.server.ServerWebExchange;

import com.flightapp.gateway.util.JwtUtil;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {
	public JwtAuthenticationFilter() {
		super(Config.class);
	}

	private ServerHttpResponse response;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
			final List<String> apiEndpoints = List.of("/register", "/login","/pnr");

			Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
					.noneMatch(uri -> r.getURI().getPath().contains(uri));
			if (isApiSecured.test(request)) {
				if (!request.getHeaders().containsKey("Authorization")) {
					return errorResponse(HttpStatus.UNAUTHORIZED, exchange);
				}
				final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

				try {
					jwtUtil.validateToken(token);
				} catch (Exception e) {
					return errorResponse(HttpStatus.BAD_REQUEST, exchange);
				}

				Claims claims = jwtUtil.getClaims(token);
				String role =claims.get("role").toString();
				if (apiNotAuthorized(role, request)) {
					return errorResponse(HttpStatus.FORBIDDEN, exchange);
				}
				exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
			}
			return chain.filter(exchange);
		};
	}

	private Mono<Void> errorResponse(HttpStatus status, ServerWebExchange exchange) {
		response = exchange.getResponse();
		response.setStatusCode(status);
		return response.setComplete();
	}

	private boolean apiNotAuthorized(String role, ServerHttpRequest request) {
		switch (role) {
		case "admin":
			return !request.getURI().getPath().contains("/admin");
		case "user":
			return !request.getURI().getPath().contains("/user");
		default:
			return true;
		}
	}

	public static class Config {
		// Put the configuration properties
	}
}