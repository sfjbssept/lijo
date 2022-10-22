package com.flightapp.admin.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.dao.entity.FlightSchedule;

@Repository
public interface FlightScheduleRep extends JpaRepository<FlightSchedule, Integer>{

}
