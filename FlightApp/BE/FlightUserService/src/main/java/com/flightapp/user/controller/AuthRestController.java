package com.flightapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.user.util.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthRestController {

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody String userName) {
		String token = jwtUtil.generateToken(userName);

		return new ResponseEntity<String>(token, HttpStatus.OK);
	}

	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody String userName) {
		// Persist user to some persistent storage
		System.out.println("Info saved...");

		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}

}
