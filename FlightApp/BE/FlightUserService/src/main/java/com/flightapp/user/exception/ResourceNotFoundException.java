package com.flightapp.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String resourceName;
	private Object fieldValue;

	public ResourceNotFoundException(String fieldName, String resourceName, Object fieldValue) {
		super(String.format("%s  not found with %s : %d ", resourceName,fieldName,fieldValue));
		this.fieldName = fieldName;
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

}