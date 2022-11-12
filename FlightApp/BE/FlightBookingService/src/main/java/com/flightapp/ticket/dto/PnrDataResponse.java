package com.flightapp.ticket.dto;

import java.util.List;

import lombok.Data;

@Data
public class PnrDataResponse {
  private BookingDetailDto bookingDetailDto;
  private FlightDataDto flightDataDto;
  private List<PassengerDto> passengerDtoList;
}
