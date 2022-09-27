package com.flightapp.admin.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.admin.dao.entity.Airline;

public interface IAirlineRepo extends JpaRepository<Airline,Integer> {

}
