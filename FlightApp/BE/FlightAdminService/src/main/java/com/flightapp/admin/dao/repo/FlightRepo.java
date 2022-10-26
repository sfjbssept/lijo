package com.flightapp.admin.dao.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dao.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

	Optional<Flight> findByFlightCode(String flightCode);

}
