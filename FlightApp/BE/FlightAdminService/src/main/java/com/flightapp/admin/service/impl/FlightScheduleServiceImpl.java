package com.flightapp.admin.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.admin.dao.entity.FlightSchedule;
import com.flightapp.admin.dao.repo.FlightScheduleRep;
import com.flightapp.admin.dto.FlightScheduleDto;
import com.flightapp.admin.service.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService{

	
	@Autowired
	FlightScheduleRep flightScheduleRep;
	
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public Integer addNewSchedule(FlightScheduleDto flightScheduleDto) {
		// TODO Auto-generated method stub
		adminServiceImpl.getFlight(flightScheduleDto.getFlightId());
		FlightSchedule flightSchedule = modelMapper.map(flightScheduleDto, FlightSchedule.class); 
		flightSchedule=	flightScheduleRep.save(flightSchedule);
		return flightSchedule.getId();
	}
	@Override
	public FlightSchedule getSchedule(Integer scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FlightSchedule> getAllScheduleByFlight(Integer flightId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FlightSchedule> getAllScheduleByAirline(Integer airlineId) {
		// TODO Auto-generated method stub
		return null;
	}

}
