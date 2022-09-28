package com.flightapp.admin.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FlightScheduleDto {
	
	private String sourceLocation;
	
	private String destination;
	
	private Timestamp departureTime;
	
	private Timestamp arrivalTime;
	
	private Integer flightDuration;
	
	private String gateNumber;
	
	private float businessClassCost;
	
	private float economyClassCost;
	
	private Integer flightId;
}
