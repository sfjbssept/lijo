package com.flightapp.search.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.search.entity.FlightSchedule;

@Repository
public interface FlightScheduleRep extends JpaRepository<FlightSchedule, Integer>{

}
