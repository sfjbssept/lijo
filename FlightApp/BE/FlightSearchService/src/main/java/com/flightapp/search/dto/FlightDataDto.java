package com.flightapp.search.dto;

import java.sql.Timestamp;

public interface FlightDataDto {
	
	String getSourceLocation();
	
	 String getDestination();
	
	 Timestamp getDepartureTime();
	
	 Timestamp getArrivalTime();
	
	 String getFlightDuration();
	
	 String getGateNumber();
	
	 String getFlightCode();
	
	 String getAirlineName();
	
	 String getAircraftModel();
}
