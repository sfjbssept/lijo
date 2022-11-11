package com.flightapp.ticket.service.impl;

import org.apache.commons.lang.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.ticket.dto.BookingDetailDto;
import com.flightapp.ticket.entity.BookingDetail;
import com.flightapp.ticket.repo.BookingDetailRepo;
import com.flightapp.ticket.repo.TicketDetailRepo;
import com.flightapp.ticket.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	ModelMapper mapper = new  ModelMapper(); 
	@Autowired
	BookingDetailRepo bookingDetailRepo;
	
	@Autowired
	TicketDetailRepo ticketDetailRepo;
	
	@Override
	public String bookingTicket(BookingDetailDto bookingDetailDto) {
		try {
			BookingDetail bookingDetail = mapDtoToEntity(bookingDetailDto, BookingDetail.class);
			bookingDetail.setPnr( generatePnrNumber(bookingDetail));
				bookingDetail = bookingDetailRepo.save(bookingDetail);
				return bookingDetail.getPnr();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
		
	}

	private BookingDetail mapDtoToEntity(BookingDetailDto bookingDetailDto, Class<BookingDetail> class1) {
		BookingDetail bookingDetail = mapper.map(bookingDetailDto, BookingDetail.class);
		bookingDetail.getTicketDetail().forEach(i->{
			i.setBookingDetail(bookingDetail);
		});
		
		return bookingDetail;
	}

	private String generatePnrNumber(BookingDetail bookingDetail) {
		Integer maxTicketID = bookingDetailRepo.findMaxId();
		String randomString = RandomStringUtils.randomAlphanumeric(4);
		return randomString.concat(maxTicketID.toString());
	}
}
