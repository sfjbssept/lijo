package com.flightapp.search.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.search.dto.FlightDataDto;
import com.flightapp.search.entity.Airline;

@Repository
public interface AirlineRepo extends JpaRepository<Airline,Integer> {
	@Query( value = "SELECT u.source as sourceLocation,\n"
			+ "u.destination,\n"
			+ "u.departure_time as departureTime,\n"
			+ "u.arrival_time as arrivalTime,\n"
			+ "u.duration as flightDuration,\n"
			+ "u.gate_no as gateNumber,\n"
			+ "b.flight_code as flightCode,\n"
			+ "b.aircraft_model as aircraftModel,\n"
			+ "a.airline_name as airlineName\n"
			+ " FROM flight_db.tb_flight_schedule as u join flight_db.tb_flight b on(u.flight_id=b.id)\n"
			+ " join flight_db.tb_airline a on (a.id =b.airline_id) where u.id= ?1",nativeQuery = true)
	 FlightDataDto getFlightData(Integer id);
}
