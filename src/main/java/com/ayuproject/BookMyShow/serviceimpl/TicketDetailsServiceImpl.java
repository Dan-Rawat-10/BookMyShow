package com.ayuproject.BookMyShow.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuproject.BookMyShow.daoimpl.TicketDetailsDaoImpl;
import com.ayuproject.BookMyShow.model.TicketDetails;
import com.ayuproject.BookMyShow.service.TicketDetailsService;

@Service
public class TicketDetailsServiceImpl implements TicketDetailsService {
	
	@Autowired
	TicketDetailsDaoImpl ticketDetailsDaoImpl;
	
	@Override
	public TicketDetails selectSeat(int ticketDetailsId, String seatName) {
		TicketDetails ticketDetails = ticketDetailsDaoImpl.getTicketDetails(ticketDetailsId, seatName);
		return ticketDetailsDaoImpl.updateTimeStampOfTicketDetails(ticketDetailsId, ticketDetails);
	}

	@Override
	public TicketDetails buyTicket(int ticketDetailsId, String seatName) {
		TicketDetails ticketDetails = ticketDetailsDaoImpl.getTicketDetails(ticketDetailsId, seatName);
		return ticketDetailsDaoImpl.updateAvailabilityOfBoughtTicket(ticketDetailsId, ticketDetails);
	}
	
}
