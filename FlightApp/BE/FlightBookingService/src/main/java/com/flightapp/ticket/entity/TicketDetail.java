package com.flightapp.ticket.entity;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_ticket_detail")
public class TicketDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "booking_id" ,nullable = false)
	@JsonIgnore
	private BookingDetail bookingDetail;
	@Column(name ="booking_id" ,insertable = false,updatable = false)
	private Integer bookingId;
	
	private String flightClass;
	
	private Float ticketCost;
	
	private String mealType;
	
	private Integer passengerId;
	
	private String status;
}
