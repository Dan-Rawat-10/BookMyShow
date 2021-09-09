package com.ayuproject.BookMyShow.service;

import java.util.List;
import java.util.Map;

import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.model.TicketDetails;

public interface CinemaService {
	Map<Event,List<TicketDetails>> getCinemaDetails(String cinema);
}
