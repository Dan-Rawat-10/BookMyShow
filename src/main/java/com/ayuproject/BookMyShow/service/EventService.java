package com.ayuproject.BookMyShow.service;

import java.util.List;

import com.ayuproject.BookMyShow.model.Event;

public interface EventService {
	Event saveMovie(Event event);
	List<Event> getMovieDetailsList(String eventName);
}
