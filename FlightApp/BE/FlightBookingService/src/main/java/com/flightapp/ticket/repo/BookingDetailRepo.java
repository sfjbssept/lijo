package com.flightapp.ticket.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.ticket.entity.BookingDetail;

public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer>{

	@Query("select max(id) as id from BookingDetail")
	Integer findMaxId();

	@Query("select u  from BookingDetail as u where u.pnr=?1")
	Optional<BookingDetail> findByPnr(String pnrNumber);
}
 