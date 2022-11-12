package com.flightapp.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {

	private String pnrNumber;
	private String message;
}
