package com.flightapp.admin.dto;

import lombok.Data;

@Data
public class FlightDto {

	
	private String flightCode;
	
	
	private Integer flightRowCount;
	
	
	private Integer businessClassSeatCount;
	
	
	private Integer economyClassSeatCount;
	
	
	private String scheduledDays;
	

	private String instrument;
	
	
	private String status;
	

	private Boolean internationalService;
	

	private Boolean domesticService;
}
