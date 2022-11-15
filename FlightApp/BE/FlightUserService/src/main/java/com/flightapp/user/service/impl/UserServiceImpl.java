package com.flightapp.user.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.user.exception.ResourceNotFoundException;
import com.flightapp.user.dao.entity.Passenger;
import com.flightapp.user.dao.entity.UserData;
import com.flightapp.user.dao.repo.UserDataRepo;
import com.flightapp.user.dao.repo.PassengerRepo;
import com.flightapp.user.dto.PassengerDto;
import com.flightapp.user.dto.UserDto;
import com.flightapp.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDataRepo userDataRepo;
	
	@Autowired
	private  PassengerRepo passengerRepo;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public UserData addUserData(UserDto userDto) {
	
		return userDataRepo.save(mapper.map(userDto, UserData.class));
		
	}
	
	@Override
	public Integer addPassenger(PassengerDto passengerDto) {
		UserData userData =  userDataRepo.findById(passengerDto.getUserId()).orElseThrow(()->
		new ResourceNotFoundException("id","User",passengerDto.getUserId()));
		Passenger passenger = mapToEntity(passengerDto, userData);
		passenger =  passengerRepo.save(passenger);
		return passenger.getId();
	}

	private Passenger mapToEntity(PassengerDto passengerDto, UserData userData) {
		Passenger passenger = mapper.map(passengerDto, Passenger.class);
		passenger.setUserData(userData);
		return passenger;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Passenger> getPassengersData(Integer userId) {
		// TODO Auto-generated method stub
		return passengerRepo.findByUserId(userId);
	}

	@Override
	public PassengerDto getPassengerData(Integer id) {
		Passenger passenger =  passengerRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("id","Passenger",id));
		return mapper.map(passenger, PassengerDto.class);
	}
	
}
