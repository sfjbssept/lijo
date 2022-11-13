package com.flightapp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginException(String fieldName, String resourceName, Object fieldValue) {
		super(String.format("UnAuthorized"));
	}
	public LoginException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
