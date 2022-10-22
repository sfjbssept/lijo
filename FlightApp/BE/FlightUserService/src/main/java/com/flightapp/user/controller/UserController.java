package com.flightapp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.user.dto.PassengerDto;
import com.flightapp.user.dto.UserDto;
import com.flightapp.user.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	//add user
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
		userService.addUserData(userDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	//add passenger
	@PostMapping(value = "passenger")
	public ResponseEntity<PassengerDto> addPassenger(@RequestBody PassengerDto passengerDto){
		userService.addPassenger(passengerDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		
	}
	
	
	//delete user
	
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		
	}
}
