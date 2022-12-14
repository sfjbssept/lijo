package com.flightapp.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dao.entity.Flight;
import com.flightapp.admin.dao.repo.AirlineRepo;
import com.flightapp.admin.dao.repo.FlightRepo;
import com.flightapp.admin.dto.AirLineName;
import com.flightapp.admin.dto.AirlineRequestDto;
import com.flightapp.admin.dto.FlightDto;
import com.flightapp.admin.exception.ResourceExistException;
import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	AirlineRepo airlineRepo;
	
	@Autowired
	FlightRepo flightRepo;
	
	ModelMapper mapper = new  ModelMapper();  
	
	@Override
	public String SaveAirline(AirlineRequestDto airlineRequestDto) {
		Airline airline =  airlineRepo.save(mapDtoToEntity(airlineRequestDto));
		return airline.getId().toString();
	}
	

	@Override
	public void deleteAirlines(Integer id) {
		airlineRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Airline",id));
	    airlineRepo.deleteById(id);
	}

	@Override
	public Airline getAirline(Integer id) {
		return airlineRepo.findById(id).orElseThrow(()->
        new ResourceNotFoundException("id","Airline",id));
	}
	
	@Override
	public List<Airline> getAirline() {
		return airlineRepo.findAll();
	}

	@Override
	public void updateAirline(AirlineRequestDto airLine, Integer id) {
		airlineRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Airline",id));
	    airlineRepo.save(mapDtoToEntity(airLine));
		
	}

	//*******************FLIGHT******************//
	@Override
	public String SaveFlight(FlightDto flightDto) {
		flightDto.setScheduledDays("DAILY");
		Flight flight = mapper.map(flightDto, Flight.class);
		flight.setAirline(getAirline(flightDto.getAirlineId()));
		Optional<Flight> f =flightRepo.findByFlightCode(flight.getFlightCode());  
		if(f.isPresent() && flightDto.getId()==null) {
		throw new  ResourceExistException("FLightCode","Flight",Integer.parseInt(flightDto.getFlightCode()));
		}
	    flight =  flightRepo.save(flight);
		return flight.getId().toString();
	}

	@Override
	public void deleteFlight(Integer id) {
		flightRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Flight",id));
		flightRepo.deleteById(id);
		
	}


	@Override
	public void updateFlight(FlightDto flightDto, Integer id) {
		flightRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Flight",id));
		flightRepo.save(mapper.map(flightDto, Flight.class));
		
	}
	
	
	private Airline mapDtoToEntity(AirlineRequestDto airLineRequest) {
		Airline airline = mapper.map(airLineRequest, Airline.class);
		airline.getFlightList().forEach((ele-> {
			ele.setAirline(airline);
		}));
		return airline;
		
	}

	@Override
	public List<Flight> getFlightByAirlineId(Integer airlineId) {
		Airline airline = getAirline(airlineId);
		return (List<Flight>) airline.getFlightList();
		
	}


	@Override
	public Flight getFlight(Integer id) {
		return flightRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Flight",id));
	}


	@Override
	public List<AirLineName> getAirLinesNames() {
		return airlineRepo.findAirlineNames();
	}


	@Override
	public List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}

}
