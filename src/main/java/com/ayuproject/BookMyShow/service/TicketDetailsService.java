package com.ayuproject.BookMyShow.service;

import com.ayuproject.BookMyShow.model.TicketDetails;

public interface TicketDetailsService {
	public TicketDetails selectSeat(int id, String seatName);
	public TicketDetails buyTicket(int id, String seatName);
}
