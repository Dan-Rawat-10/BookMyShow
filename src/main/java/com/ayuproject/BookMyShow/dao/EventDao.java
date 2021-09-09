package com.ayuproject.BookMyShow.dao;

import java.util.List;

import com.ayuproject.BookMyShow.model.Event;

public interface EventDao {
	Event saveEvent(Event event);
	List<Event> getMovieDetailsListByMovieName(String eventName);
}
