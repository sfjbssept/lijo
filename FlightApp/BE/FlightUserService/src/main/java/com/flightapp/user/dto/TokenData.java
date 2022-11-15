package com.flightapp.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TokenData {

	private String name;
	private String token;
	private Date tokenExpirationDate;
	private String gender;
	private String role;
}
