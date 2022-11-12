package com.flightapp.ticket.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightapp.ticket.dto.FlightDataDto;

@FeignClient( name = "FLIGHT-SEARCH-SERVICE")
public interface FlightClient {

	@GetMapping(value = "/search/flight/Data/{flightScheduleId}")
	FlightDataDto getFlightData( @PathVariable("flightScheduleId") Integer flightScheduleId);
	
}
