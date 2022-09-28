package com.flightapp.user.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PassengerDto {

	private Integer  userId;
	private String name;
	private String address;
	private String passportNo;
	private String idCardNo;
	private String idCardType;
	private String gender;
	private Integer age;
	private Date dob;
	private Long phone;
	private String email;
	
}
