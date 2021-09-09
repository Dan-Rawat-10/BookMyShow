package com.ayuproject.BookMyShow.dao;

import com.ayuproject.BookMyShow.model.TicketDetails;

public interface TicketDetailsDao {
	public TicketDetails getTicketDetails(int id, String seatName);
}
