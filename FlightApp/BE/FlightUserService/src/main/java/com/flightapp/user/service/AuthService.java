package com.flightapp.user.service;

import org.apache.http.auth.AuthenticationException;

import com.flightapp.user.dto.AuthData;

public interface AuthService {

	String login(AuthData authData) throws AuthenticationException;

}
