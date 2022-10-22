package com.flightapp.search.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.search.dao.repo.FlightScheduleRep;
import com.flightapp.search.dto.FlightScheduleDto;
import com.flightapp.search.entity.FlightSchedule;
import com.flightapp.search.service.FlightSerchService;

@Service
public class FlightSearchServiceImpl implements FlightSerchService {

	@Autowired
	FlightScheduleRep flightScheduleRep;
	
	ModelMapper mapper = new  ModelMapper();  
	
	@Override
	public List<FlightScheduleDto> searchFlight() {
		List<FlightSchedule> flightSchedule =  flightScheduleRep.findAll();
		
		return mapper.map(flightSchedule, new TypeToken<List<FlightScheduleDto>>() {}.getType());
	}


}
