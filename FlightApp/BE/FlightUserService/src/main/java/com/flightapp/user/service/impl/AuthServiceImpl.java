package com.flightapp.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightapp.user.dao.entity.Passenger;
import com.flightapp.user.dao.entity.UserData;
import com.flightapp.user.dao.repo.UserDataRepo;
import com.flightapp.user.dto.AuthData;
import com.flightapp.user.dto.TokenData;
import com.flightapp.user.exception.LoginException;
import com.flightapp.user.service.AuthService;
import com.flightapp.user.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	UserDataRepo userDataRepo;
	
	@Override
	public TokenData login(AuthData authData) {
		UserData userData=userDataRepo.findByUsername(authData.getUsername());
		if(isPasswordMatch(userData.getPassword(), authData.getPassword())) {
		String token = jwtUtil.generateToken(authData.getUsername(),userData.getRole());
		return setTokenData(userData,token);
		}
	    throw new LoginException();
	}

	 private TokenData setTokenData(UserData userData, String token) {
		Optional<Passenger> passenger = userData.getPassengerList().stream().
				filter(k -> k.getUserType().equalsIgnoreCase("primary")).findFirst();
		TokenData tokenData = new TokenData();
		tokenData.setToken(token);
		if(passenger.isPresent()) {
			tokenData.setName(passenger.get().getName());
			tokenData.setGender(passenger.get().getGender());
		}
		tokenData.setTokenExpirationDate(jwtUtil.getExpirationDate(token));
		tokenData.setRole(userData.getRole());
		tokenData.setUserId(userData.getId());
		return tokenData;
	}

	boolean isPasswordMatch(String encodedPwd,String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    return passwordEncoder.matches(password,encodedPwd);
	}
}
