package com.flightapp.ticket.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FlightDataDto {
	
	private String sourceLocation;
	
	private String destination;
	
	private Timestamp departureTime;
	
	private Timestamp arrivalTime;
	
	private Integer flightDuration;
	
	private String gateNumber;
	
	private String flightCode;
	
	private String airlineName;
	
	private String aircraftModel;
}
