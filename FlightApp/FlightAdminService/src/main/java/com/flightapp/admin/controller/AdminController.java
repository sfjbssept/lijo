package com.flightapp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dao.entity.Flight;
import com.flightapp.admin.dto.AirlineRequestDto;
import com.flightapp.admin.dto.FlightDto;
import com.flightapp.admin.service.AdminService;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	// add airline
	@PostMapping(value = "airline/register")
	public ResponseEntity<AirlineRequestDto> addAirline(@RequestBody AirlineRequestDto airLine) {
		adminService.SaveAirline(airLine);
		return new ResponseEntity<>(airLine, HttpStatus.OK);
	}

	// delete airline
	@DeleteMapping(value = "airline/{id}")
	public ResponseEntity<Airline> deleteAirline(@PathVariable Integer id) {
		adminService.deleteAirlines(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	// get airlines by Id

	@GetMapping(value = "airline/{id}")
	public Airline getAirline(@PathVariable Integer id) {
		return adminService.getAirline(id);

	}

	// get All airlines

	@GetMapping(value = "airline")
	public List<Airline> getAirline() {
		return adminService.getAirline();

	}

	// update airline

	@PutMapping(value = "airline/{id}")
	public ResponseEntity<AirlineRequestDto> updateAirline(@PathVariable Integer id,
			@RequestBody AirlineRequestDto airLine) {
		adminService.updateAirline(airLine, id);
		return new ResponseEntity<>(airLine, HttpStatus.ACCEPTED);
	}

	// ********************** FLIGHT
	// ***********************************************//

	// add flight
	@PostMapping(value = "flight/{id}")
	public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto,@PathVariable Integer id) {
		adminService.SaveFlight(flightDto,id);
		return new ResponseEntity<>(flightDto, HttpStatus.OK);
	}

	// delete flight
	@DeleteMapping(value = "flight/{id}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable Integer id) {
		adminService.deleteAirlines(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	// get flight

	@GetMapping(value = "flight/{id}")
	public Flight getFlight(@PathVariable Integer id) {
		return adminService.getFlight(id);

	}

	// update flight

	@PutMapping(value = "fight/{id}")
	public ResponseEntity<FlightDto> updateFlight(@PathVariable Integer id, @RequestBody FlightDto flightDto) {
		adminService.updateFlight(flightDto, id);
		return new ResponseEntity<>(flightDto, HttpStatus.ACCEPTED);
	}

}

//{
//	  "airlineName": "SpiceJet",
//	  "airlineCode": "SG",
//	  "status": "active",
//	  "flightCount": 3,
//	  "websiteUrl": "spicejet.com",
//	  "flightList": [
//	    {
//	      "flightCode": "8185",
//	      "flightRowCount": 21,
//	      "businessClassSeatCount": 24,
//	      "economyClassSeatCount": 90,
//	      "scheduledDays": "MON,TUE",
//	      "instrument": "Boeing 737",
//	      "status": "active",
//	      "internationalService": true,
//	      "domesticService": false
//	    }
//	  ],
//	  "contactNumber": 8056894018
//	}
