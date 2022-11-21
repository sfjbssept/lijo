package com.flightapp.ticket.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.ticket.dto.BookingDetailDto;
import com.flightapp.ticket.dto.FlightDataDto;
import com.flightapp.ticket.dto.PassengerDto;
import com.flightapp.ticket.dto.PnrDataResponse;
import com.flightapp.ticket.entity.BookingDetail;
import com.flightapp.ticket.entity.Passenger;
import com.flightapp.ticket.exception.ResourceNotFoundException;
import com.flightapp.ticket.feign.FlightClient;
import com.flightapp.ticket.feign.UserClient;
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
	
	@Autowired
	FlightClient flightClient;
	
	@Autowired
	UserClient userClient;
	
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
		String randomString = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
		return randomString.concat(maxTicketID!=null?maxTicketID.toString(): "1");
	}

	@Override
	public PnrDataResponse getPnrData(String pnrNumber) {
		PnrDataResponse pnrDataResponse = new PnrDataResponse();
		List<PassengerDto> list = new ArrayList();
		BookingDetail bookingDetail=bookingDetailRepo.findByPnr(pnrNumber).orElseThrow(()->
		new ResourceNotFoundException("PNR","PnrNumber",pnrNumber));
		BookingDetailDto bookingDetailDto = mapper.map(bookingDetail, BookingDetailDto.class);
		pnrDataResponse.setBookingDetailDto(bookingDetailDto);
		try {
		FlightDataDto flightDataDto = 	flightClient.getFlightData(bookingDetailDto.getFlightScheduleId());
		pnrDataResponse.setFlightDataDto(flightDataDto);
		} catch (Exception e) {
			new ResourceNotFoundException("PNR",e.getMessage()+ " PnrNumber",pnrNumber);
		}
		try {
			bookingDetail.getTicketDetail().forEach(item->{
				list.add(userClient.getPassengerData(item.getPassengerId()));
			});
			pnrDataResponse.setPassengerDtoList(list);
		} catch (Exception e) {
			new ResourceNotFoundException("PNR",e.getMessage()+ " PnrNumber",pnrNumber);
		}
		return pnrDataResponse;
	}
	@Override
	public List<PnrDataResponse> getBookingHistory(String userId) {
		List<PassengerDto> list = new ArrayList();
		Type listType = new TypeToken<List<BookingDetailDto>>(){}.getType();
		List<PnrDataResponse> pnrDataList = new ArrayList<PnrDataResponse>();
		try {
			List<Passenger> passengers =  userClient.getPassengerDataByUserId(userId);
			Set<BookingDetailDto> bookingDetailSet = new HashSet<>();
			passengers.forEach(p-> {
				List<BookingDetail> bookingDetail=bookingDetailRepo.findByPassengerId(p.getId());
				List<BookingDetailDto> bookingDetailDto = mapper.map(bookingDetail, listType);
				bookingDetailSet.addAll(bookingDetailDto);
			});
			bookingDetailSet.forEach(b->{
				PnrDataResponse pnrDataResponse = new PnrDataResponse();
				FlightDataDto flightDataDto = 	flightClient.getFlightData(b.getFlightScheduleId());
				
				pnrDataResponse.setFlightDataDto(flightDataDto);
				pnrDataResponse.setBookingDetailDto(b);
				List<PassengerDto> pList = new ArrayList<>();
				b.getTicketDetail().forEach(item->{
					Optional<Passenger> passenger=  passengers.stream().filter(s->s.getId()==item.getPassengerId()).findFirst();
				    if(passenger.isPresent()) {
				    	pList.add(mapper.map(passenger.get(),PassengerDto.class));
				    }
					
				});
				pnrDataResponse.setPassengerDtoList(pList);
				pnrDataList.add(pnrDataResponse);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return pnrDataList;
	}
}
