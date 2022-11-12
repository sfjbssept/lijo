package com.flightapp.search.service;

import java.util.List;

import com.flightapp.search.dto.FlightDataDto;
import com.flightapp.search.dto.FlightScheduleDto;

public interface FlightSerchService {

	List<FlightScheduleDto> searchFlight(String from, String to, String departureDate);

	FlightDataDto getFlightData(Integer flightScheduleId);
}
