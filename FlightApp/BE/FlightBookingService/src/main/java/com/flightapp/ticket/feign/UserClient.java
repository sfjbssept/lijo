package com.flightapp.ticket.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightapp.ticket.dto.PassengerDto;

@FeignClient(name = "FLIGHT-USER-SERVICE")
public interface UserClient {

	@GetMapping(value = "/user/passenger/{id}")
	PassengerDto getPassengerData( @PathVariable("id") Integer id);
}
