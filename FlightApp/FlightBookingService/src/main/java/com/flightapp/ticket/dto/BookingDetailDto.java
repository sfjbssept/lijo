package com.flightapp.ticket.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BookingDetailDto {

	private String pnr;
	private Timestamp bookingDate;
	private Integer flightScheduleId;
}
