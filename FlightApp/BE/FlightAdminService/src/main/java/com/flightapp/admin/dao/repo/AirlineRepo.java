package com.flightapp.admin.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.dao.entity.Airline;
import com.flightapp.admin.dto.AirLineName;

@Repository
public interface AirlineRepo extends JpaRepository<Airline,Integer> {

	@Query( value = "select airline_name as airlineName,id from tb_airline",nativeQuery = true)
	List<AirLineName> findAirlineNames();

}
