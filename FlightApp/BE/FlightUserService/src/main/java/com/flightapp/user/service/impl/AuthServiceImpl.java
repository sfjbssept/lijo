package com.flightapp.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightapp.user.dao.entity.UserData;
import com.flightapp.user.dao.repo.UserDataRepo;
import com.flightapp.user.dto.AuthData;
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
	public String login(AuthData authData) {
		UserData userData=userDataRepo.findByUsername(authData.getUsername());
		if(isPasswordMatch(userData.getPassword(), authData.getPassword())) {
		String token = jwtUtil.generateToken(authData.getUsername());
		return token;
		}
	    new LoginException();
		return null;
	}

	 boolean isPasswordMatch(String encodedPwd,String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    return passwordEncoder.matches(password,encodedPwd);
	}
}
