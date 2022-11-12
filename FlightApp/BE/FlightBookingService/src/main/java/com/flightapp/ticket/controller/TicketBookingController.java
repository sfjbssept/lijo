package com.flightapp.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.ticket.dto.BookingDetailDto;
import com.flightapp.ticket.dto.BookingResponse;
import com.flightapp.ticket.service.BookingService;

@RestController
@RequestMapping("/booking")
public class TicketBookingController extends BaseController{

	@Autowired
	BookingService bookingService;
	@PostMapping
	public ResponseEntity<?> bookTicket(@RequestBody BookingDetailDto bookingDetailDto) {
		
		String pnrNumber =  bookingService.bookingTicket(bookingDetailDto);
		BookingResponse bookingResponse = new BookingResponse(pnrNumber,"Ticket booked successfully");
		return buildResponseMessage(HttpStatus.OK, bookingResponse);
		
	}
}
