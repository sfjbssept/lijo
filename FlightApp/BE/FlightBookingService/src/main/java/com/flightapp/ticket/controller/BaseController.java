package com.flightapp.ticket.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.flightapp.ticket.dto.BookingResponse;
import com.flightapp.ticket.dto.PnrDataResponse;

public class BaseController {

   ResponseEntity<Map<String, Object>> buildResponseMessage(HttpStatus status, Object pnrDataResponse) {
	   Map<String, Object> body = new LinkedHashMap<>();
       body.put("timestamp", LocalDateTime.now());
       body.put("data", pnrDataResponse);
       return new ResponseEntity<>(body, status);
	}
 
}
