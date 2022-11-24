package com.flightapp.admin.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.dao.entity.FlightSchedule;
import com.flightapp.admin.dto.FlightScheduleDto;
import com.flightapp.admin.service.FlightScheduleService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "admin/flight/schedule")
@Slf4j
public class FlightScheduleController extends BaseController{

 	private static Logger logger =LoggerFactory.getLogger(FlightScheduleController.class);
	@Autowired
	FlightScheduleService flightScheduleService;
	
	@PostMapping(value = "add")
	public ResponseEntity<?> addNewSchedule(@RequestBody FlightScheduleDto flightScheduleDto) {
		
		logger.info("addNewSchedule Started");
		Integer id = flightScheduleService.addNewSchedule(flightScheduleDto);
		
		return buildResponseMessage(HttpStatus.OK, "FLight added successfully with ID:"+id);
	}
	
	@GetMapping
	public FlightSchedule getFlightSchedule(@PathVariable Integer id) {
		
		logger.info("addNewSchedule Started");
		//return null;
		
		return flightScheduleService.getSchedule(id);
	}
	
	
}
