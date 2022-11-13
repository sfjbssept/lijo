package com.flightapp.user.controller;

import org.apache.http.auth.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.user.dto.AuthData;
import com.flightapp.user.service.AuthService;


@RestController
public class AuthRestController {

	@Autowired
	AuthService authService;
	@PostMapping("/auth/login")
	public ResponseEntity<String> login(@RequestBody AuthData authData) throws AuthenticationException {
		String token = authService.login(authData);
		return new ResponseEntity<String>(token, HttpStatus.OK);
	}

	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody String userName) {
		// Persist user to some persistent storage
		System.out.println("Info saved...");

		return new ResponseEntity<String>("Registered", HttpStatus.OK);
	}

}
