package com.flightapp.admin.service;

import java.util.List;
import java.util.Optional;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dao.entity.Flight;
import com.flightapp.admin.dto.AirlineRequestDto;
import com.flightapp.admin.dto.FlightDto;

public interface AdminService {

	String SaveAirline(AirlineRequestDto airLine);

	void deleteAirlines(Integer id);

	List<Airline> getAirline();

	void updateAirline(AirlineRequestDto airLine, Integer id);
	
	
	String SaveFlight(FlightDto flightDto, Integer id);

	void deleteFlight(Integer id);

	Flight getFlight(Integer id);

	void updateFlight(FlightDto flightDto, Integer id);

	Airline getAirline(Integer id);


	List<Flight> getFlightByAirlineId(Integer airlineId);

}
