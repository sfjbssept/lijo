package com.flightapp.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.search.dto.FlightDataDto;
import com.flightapp.search.dto.FlightScheduleDto;
import com.flightapp.search.service.FlightSerchService;

@RestController
@RequestMapping("/search")
public class FlightSearchController {

	@Autowired
	FlightSerchService flightSerchService;
	@GetMapping()
	public ResponseEntity<List<FlightScheduleDto>> searchFlights(@RequestParam String from ,@RequestParam String to,@RequestParam String depDate){
		List<FlightScheduleDto> list = flightSerchService.searchFlight(from,to,depDate);
		return new ResponseEntity<List<FlightScheduleDto>>(list, HttpStatus.OK);
		
	}
	@GetMapping("/flight/Data/{flightScheduleId}")
	public FlightDataDto getFlightData(@PathVariable Integer flightScheduleId) {
		return flightSerchService.getFlightData(flightScheduleId);
		
	}
	
}
