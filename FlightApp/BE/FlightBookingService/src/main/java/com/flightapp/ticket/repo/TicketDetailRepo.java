package com.flightapp.ticket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.ticket.entity.TicketDetail;

public interface TicketDetailRepo extends JpaRepository<TicketDetail, Integer>{

	

}
