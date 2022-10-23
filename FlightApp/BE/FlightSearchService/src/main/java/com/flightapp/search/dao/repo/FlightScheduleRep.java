package com.flightapp.search.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.search.entity.FlightSchedule;

@Repository
public interface FlightScheduleRep extends JpaRepository<FlightSchedule, Integer>{

	@Query("SELECT u FROM FlightSchedule u WHERE u.sourceLocation = ?1 and u.destination = ?2")
	List<FlightSchedule> searchFlightSchedule(String from, String to);

}
