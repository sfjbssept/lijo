package com.flightapp.ticket.service;

import com.flightapp.ticket.dto.BookingDetailDto;
import com.flightapp.ticket.dto.PnrDataResponse;

public interface BookingService {

	public String bookingTicket(BookingDetailDto bookingDetailDto);

	public PnrDataResponse getPnrData(String pnrNumber);

}
