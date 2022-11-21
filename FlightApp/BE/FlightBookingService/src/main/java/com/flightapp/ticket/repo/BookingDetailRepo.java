package com.flightapp.ticket.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.ticket.entity.BookingDetail;

public interface BookingDetailRepo extends JpaRepository<BookingDetail, Integer>{

	@Query("select max(id) as id from BookingDetail")
	Integer findMaxId();

	@Query("select u  from BookingDetail as u where u.pnr=?1")
	Optional<BookingDetail> findByPnr(String pnrNumber);

	@Query("select u from BookingDetail as u join TicketDetail as t on u.id=t.bookingId where t.passengerId=?1")
	List<BookingDetail> findByPassengerId(Integer passengerId);
}
 