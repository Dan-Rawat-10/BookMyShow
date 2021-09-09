package com.ayuproject.BookMyShow.serviceimpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuproject.BookMyShow.daoimpl.CinemaDaoImpl;
import com.ayuproject.BookMyShow.daoimpl.EventDaoImpl;
import com.ayuproject.BookMyShow.daoimpl.TicketDetailsDaoImpl;
import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.model.TicketDetails;
import com.ayuproject.BookMyShow.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService{
	
	@Autowired
	CinemaDaoImpl cinemaDaoImpl;
	
	@Autowired
	EventDaoImpl eventDaoImpl;
	
	@Autowired
	TicketDetailsDaoImpl ticketDetailsDaoImpl;
	
	@Override
	public Map<Event, List<TicketDetails>> getCinemaDetails(String cinema) {
		Map<Event, List<TicketDetails>> eventTicketDetailsMap = new HashMap<>();
		List<Event> eventList = eventDaoImpl.getMovieDetailsListByCinemaName(cinema);
		
		if(eventList != null && !eventList.isEmpty()) {
			for(Event event : eventList) {
				List<TicketDetails> ticketDetailsList = ticketDetailsDaoImpl.getTicketDetailsListByEventId(event.getId());
				
				if (ticketDetailsList != null && !ticketDetailsList.isEmpty()) {
					List<TicketDetails> updatedTicketDetailsList = getValidTicketDetailsList(ticketDetailsList);
					eventTicketDetailsMap.put(event, updatedTicketDetailsList);
				}
			}
		}
		
		return eventTicketDetailsMap;
	}

	private List<TicketDetails> getValidTicketDetailsList(List<TicketDetails> ticketDetailsList) {
		List<TicketDetails> updatedList = new ArrayList<>();
		
		for(TicketDetails ticketDetails : ticketDetailsList) {
			if(!ticketDetails.getAvailability() || ticketDetails.getSeatSelectedTime() == null 
					|| selectedTimeGreaterThanTen(ticketDetails)) {
				updatedList.add(ticketDetails);
			}
		}
		
		return updatedList;
	}

	private boolean selectedTimeGreaterThanTen(TicketDetails ticketDetails) {
			Timestamp currentTimestamp = new java.sql.Timestamp(new java.util.Date().getTime());
			Timestamp seatSelectedTime = ticketDetails.getSeatSelectedTime();
			int minutes = currentTimestamp.getMinutes() - seatSelectedTime.getMinutes();
			return minutes > 10;
	}

}
