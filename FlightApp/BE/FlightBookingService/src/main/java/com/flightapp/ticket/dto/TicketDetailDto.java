package com.flightapp.ticket.dto;

import lombok.Data;

@Data
public class TicketDetailDto {

private String flightClass;
	
	private Float ticketCost;
	
	private String mealType;
	
	private Integer passengerId;
	
	private String status;
}
