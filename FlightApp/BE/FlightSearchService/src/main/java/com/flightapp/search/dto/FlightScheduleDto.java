package com.flightapp.search.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class FlightScheduleDto {
	
	private String sourceLocation;
	
	private String destination;
	
	private Timestamp departureTime;
	
	private Timestamp arrivalTime;
	
	private String flightDuration;
	
	private String gateNumber;
	
	private float businessClassCost;
	
	private float economyClassCost;
	
	private Integer flightId;
	
	private Integer id;
}
