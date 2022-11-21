package com.flightapp.ticket.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightapp.ticket.dto.PassengerDto;
import com.flightapp.ticket.entity.Passenger;

@FeignClient(name = "FLIGHT-USER-SERVICE")
public interface UserClient {

	@GetMapping(value = "/user/passenger/{id}")
	PassengerDto getPassengerData( @PathVariable("id") Integer id);
	
	@GetMapping(value = "/user/passengers/{userId}")
	List<Passenger> getPassengerDataByUserId(@PathVariable("userId") String userId);
}
