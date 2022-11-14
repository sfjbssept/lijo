package com.flightapp.user.service;

import org.apache.http.auth.AuthenticationException;

import com.flightapp.user.dto.AuthData;
import com.flightapp.user.dto.TokenData;

public interface AuthService {

	TokenData login(AuthData authData) throws AuthenticationException;

}
