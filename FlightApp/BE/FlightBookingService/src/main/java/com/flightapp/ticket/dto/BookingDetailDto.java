package com.flightapp.ticket.dto;

import java.sql.Timestamp;
import java.util.Set;

import lombok.Data;

@Data
public class BookingDetailDto {

	private Integer id;
	private String pnr;
	private Timestamp bookingDate;
	private Integer flightScheduleId;
	private Set<TicketDetailDto> ticketDetail;

}
