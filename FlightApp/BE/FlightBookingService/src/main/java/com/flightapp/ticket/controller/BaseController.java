package com.flightapp.ticket.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.ticket.dto.BookingResponse;

public class BaseController {

	ResponseEntity buildResponseMessage(HttpStatus status,BookingResponse message){
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("data", message);
        return new ResponseEntity<>(body, status);
	}
}
