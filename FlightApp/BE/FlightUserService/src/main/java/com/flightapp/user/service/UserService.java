package com.flightapp.user.service;

import java.util.List;

import com.flightapp.user.dao.entity.Passenger;
import com.flightapp.user.dao.entity.UserData;
import com.flightapp.user.dto.PassengerDto;
import com.flightapp.user.dto.UserDto;

public interface UserService {

	UserData addUserData(UserDto userDto);

	void deleteUser(Integer id);

	Integer addPassenger(PassengerDto passengerDto);

	List<Passenger> getPassengersData(Integer userId);

}
