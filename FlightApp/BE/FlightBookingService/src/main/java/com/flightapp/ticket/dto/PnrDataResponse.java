package com.flightapp.ticket.dto;

import lombok.Data;

@Data
public class PnrDataResponse {
  private BookingDetailDto bookingDetailDto;
  private FlightDataDto flightDataDto;
}
