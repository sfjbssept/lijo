package com.flightapp.search.service.Impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.search.dao.repo.AirlineRepo;
import com.flightapp.search.dao.repo.FlightScheduleRep;
import com.flightapp.search.dto.FlightDataDto;
import com.flightapp.search.dto.FlightScheduleDto;
import com.flightapp.search.entity.FlightSchedule;
import com.flightapp.search.service.FlightSerchService;

@Service
public class FlightSearchServiceImpl implements FlightSerchService {

	@Autowired
	FlightScheduleRep flightScheduleRep;
	
	@Autowired
	AirlineRepo airlineRepo;
	
	ModelMapper mapper = new  ModelMapper();  
	
	public List<FlightScheduleDto> searchFlight() {
		List<FlightSchedule> flightSchedule =  flightScheduleRep.findAll();
		
		return mapper.map(flightSchedule, new TypeToken<List<FlightScheduleDto>>() {}.getType());
	}


	@Override
	public List<FlightScheduleDto> searchFlight(String from, String to, String departureDate) {
		Timestamp timestamp = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 Date date =formatter.parse(departureDate);
			 timestamp =  new Timestamp(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     List<FlightSchedule> flightSchedule =  flightScheduleRep.searchFlightSchedule(from.toUpperCase(),to.toUpperCase(),timestamp);
		
		return mapper.map(flightSchedule, new TypeToken<List<FlightScheduleDto>>() {}.getType());
	}


	@Override
	public FlightDataDto getFlightData(Integer flightScheduleId) {
			return airlineRepo.getFlightData(flightScheduleId);
	}


}
