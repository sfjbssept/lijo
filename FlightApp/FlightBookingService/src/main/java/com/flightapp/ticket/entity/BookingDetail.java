package com.flightapp.ticket.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "tb_booking_detail")
public class BookingDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pnr_no")
	private String pnr;
	@Column(name = "booking_date")
	private Timestamp bookingDate;
	
	@Column(name = "flight_schedule_id")
	private Integer flightScheduleId;
	
	@OneToMany(mappedBy = "bookingDetail" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private Set<TicketDetail> ticketDetail;
	
}
