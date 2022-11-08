package com.flightapp.user.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.user.dao.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, Integer>{

	List<Passenger> findByUserId(Integer userId);

}
