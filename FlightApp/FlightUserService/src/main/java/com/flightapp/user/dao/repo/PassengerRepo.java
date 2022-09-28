package com.flightapp.user.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.user.dao.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Integer>{

}
