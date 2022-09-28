package com.flightapp.admin.dao.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_flight_Schedule")
@Getter
@Setter
public class FlightSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "flight_id")
	private Integer flightId;
	
	@Column(name = "source")
	private String sourceLocation;
	
	private String destination;
	
	@Column(name = "departure_time")
	private Timestamp departureTime;
	
	@Column(name = "arrival_time")
	private Timestamp arrivalTime;
	
	@Column(name = "duration")
	private Float flightDuration;
	
	@Column(name = "gate_no")
	private String gateNumber;
	
	@Column(name = "business_class_cost")
	private float businessClassCost;
	
	@Column(name = "economy_cost")
	private float economyClassCost;
	
	
}
