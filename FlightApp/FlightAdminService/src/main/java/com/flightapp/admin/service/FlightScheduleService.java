package com.flightapp.admin.service;

import java.util.List;

import com.flightapp.admin.dao.entity.FlightSchedule;
import com.flightapp.admin.dto.FlightScheduleDto;

public interface FlightScheduleService {

	Integer addNewSchedule(FlightScheduleDto flightScheduleDto);

	FlightSchedule getSchedule(Integer scheduleId);
	
	List<FlightSchedule> getAllScheduleByFlight(Integer flightId);
	
	List<FlightSchedule> getAllScheduleByAirline(Integer airlineId);

	
}
