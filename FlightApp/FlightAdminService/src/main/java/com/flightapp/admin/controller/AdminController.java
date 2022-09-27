package com.flightapp.admin.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dao.repo.IAirlineRepo;
import com.flightapp.admin.dto.AirlineRequestDto;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	
	@Autowired
	IAirlineRepo airlineRepo;
	

	//add airline
	@PostMapping(value = "airline")
	public ResponseEntity<AirlineRequestDto> addAirline(@RequestBody AirlineRequestDto airLine){
		
		airlineRepo.save(mapDtoToEntity(airLine));
		return new ResponseEntity<>(airLine,HttpStatus.OK);
		
		
		
	}

	private Airline mapDtoToEntity(AirlineRequestDto airLineRequest) {
		ModelMapper mapper = new  ModelMapper();  
		Airline airline = mapper.map(airLineRequest, Airline.class);
		airline.getFlightList().forEach((ele-> {
			ele.setAirline(airline);
		}));
		return airline;
		
	}
	
	
	//add admin
	
	//add flights
	
	
	//add flight schedule
	
	
	//block airline
	
	
	//delete flight
	
	
	//delete airline
	
	
	//update flights
	
	//update airline
	
	
	//update flight schedule
	
	
	//delete flight schedule
	
	
	

}
