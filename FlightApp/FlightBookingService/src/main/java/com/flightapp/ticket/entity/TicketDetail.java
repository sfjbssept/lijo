package com.flightapp.ticket.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_ticket_detail")
public class TicketDetail {

	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "booking_id" ,nullable = false)
	private BookingDetail bookingDetail;
	
	private String flightClass;
	
	private Float ticketCost;
	
	private String mealType;
	
	private Integer passengerId;
	
	private String status;
}
