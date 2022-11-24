package com.flightapp.ticket.service;

import com.flightapp.ticket.dto.BookingDetailDto;
import com.flightapp.ticket.dto.PnrDataResponse;
import com.flightapp.ticket.entity.TicketDetail;

import java.util.List;
public interface BookingService {

	public String bookingTicket(BookingDetailDto bookingDetailDto);

	public PnrDataResponse getPnrData(String pnrNumber);
   
	public List<PnrDataResponse>  getBookingHistory(String userId);

	public Boolean cancelTicket(Integer ticketId);

}
