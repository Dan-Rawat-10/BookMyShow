package com.ayuproject.BookMyShow.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayuproject.BookMyShow.daoimpl.EventDaoImpl;
import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDaoImpl eventDaoImpl;
	
	@Override
	public Event saveMovie(Event event) {
		return eventDaoImpl.saveEvent(event);
	}

	@Override
	public List<Event> getMovieDetailsList(String movieName) {
		return eventDaoImpl.getMovieDetailsListByMovieName(movieName);
	}
	
}
