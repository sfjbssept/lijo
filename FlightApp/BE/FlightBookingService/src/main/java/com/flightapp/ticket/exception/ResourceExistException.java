package com.flightapp.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String resourceName;
	private Object fieldValue;

	public ResourceExistException(String fieldName, String resourceName, Object fieldValue) {
		super(String.format("%s  already Exist with %s : %d ", resourceName,fieldName,fieldValue));
		this.fieldName = fieldName;
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
	}
	public ResourceExistException() {
		super();
		// TODO Auto-generated constructor stub
	}
}
