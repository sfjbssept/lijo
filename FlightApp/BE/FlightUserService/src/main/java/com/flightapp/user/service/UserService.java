package com.flightapp.user.service;

import com.flightapp.user.dao.entity.Passenger;
import com.flightapp.user.dao.entity.UserData;
import com.flightapp.user.dto.PassengerDto;
import com.flightapp.user.dto.UserDto;

public interface UserService {

	UserData addUserData(UserDto userDto);

	void deleteUser(Integer id);

	Passenger addPassenger(PassengerDto passengerDto);

}
