package com.flightapp.admin.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.dao.entity.Airline;

@Repository
public interface AirlineRepo extends JpaRepository<Airline,Integer> {

}
