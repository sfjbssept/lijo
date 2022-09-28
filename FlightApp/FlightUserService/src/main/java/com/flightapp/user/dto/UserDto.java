package com.flightapp.user.dto;

import lombok.Data;

@Data
public class UserDto {

	private String role;
	
	private String username;
	
	private String password;
	
    private String status;
}
