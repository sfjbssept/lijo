//package com.flightapp.secure.config;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityBasicConfig {
//
//	@Bean
//	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/post").hasAnyRole("ADMIN")
//				.antMatchers(HttpMethod.PUT, "/put/**").hasAnyRole("ADMIN", "USER").antMatchers(HttpMethod.GET, "/get")
//				.hasAnyRole("USER").and().csrf().disable().headers().frameOptions().disable();
//		return http.build();
//	}
//
//	@Bean
//	protected InMemoryUserDetailsManager userDetailsService() throws Exception {
//		List<UserDetails> userDetailsList = new ArrayList<>();
//		userDetailsList
//				.add(User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER").build());
//		userDetailsList
//				.add(User.withUsername("admin").password(passwordEncoder().encode("password")).roles("ADMIN").build());
//
//		return new InMemoryUserDetailsManager(userDetailsList);
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
//
////@SuppressWarnings("deprecation")
////@Configuration
////public class SpringSecurityBasicConfig extends WebSecurityConfigurerAdapter {
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.httpBasic().and().authorizeRequests()
////		        .antMatchers(HttpMethod.POST, "/post").hasAnyRole("ADMIN")
////				.antMatchers(HttpMethod.PUT, "/put/**").hasAnyRole("ADMIN", "USER")
////				.antMatchers(HttpMethod.GET, "/get").hasAnyRole("USER").and()
////				.csrf().disable().headers().frameOptions().disable();
////	}
////
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication()
////		        .withUser("user").password("{noop}password").roles("USER").and()
////				.withUser("admin").password("{noop}password").roles("ADMIN").and()
////				.withUser("test123").password("{noop}password").roles("USER").and()
////				.withUser("admin1").password("{noop}password")
////				.roles("ADMIN");
////
////	}
////
////}
