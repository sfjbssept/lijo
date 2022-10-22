package com.flightapp.admin.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "tb_flight")
public class Flight implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;
	
	@Column(name = "flight_code")
	private String flightCode;
	
	@Column(name = "no_of_rows")
	private Integer flightRowCount;
	
	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "airline_id", nullable = false)
	@JsonIgnore
	private Airline airline;
	
	@Column(name = "business_class_seats")
	private Integer businessClassSeatCount;
	
	@Column(name = "economy_class_seats")
	private Integer economyClassSeatCount;
	
	@Column(name = "scheduled_days")
	private String scheduledDays;
	
	@Column(name = "instrument")
	private String instrument;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "international_service")
	private Boolean internationalService;
	
	@Column(name = "domestic_service")
	private Boolean domesticService;
	
}
