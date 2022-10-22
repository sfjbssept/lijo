package com.flightapp.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private  PassengerRepo PassengerRepo;
	
	ModelMapper mapper = new ModelMapper();
	
	@Override
	public UserData addUserData(UserDto userDto) {
	
		return userDataRepo.save(mapper.map(userDto, UserData.class));
		
	}
	
	@Override
	public Passenger addPassenger(PassengerDto passengerDto) {
		Passenger p = mapper.map(passengerDto, Passenger.class);
		p.setId(null);
		return PassengerRepo.save(p);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
