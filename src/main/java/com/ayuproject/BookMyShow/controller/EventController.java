package com.ayuproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayuproject.BookMyShow.exception.ResourceNotFoundException;
import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.serviceimpl.EventServiceImpl;

@RestController
@RequestMapping("/api/movie")
public class EventController {
	
	@Autowired
	EventServiceImpl eventServiceImpl;
	
	/**
	 * 
	 * @param event
	 * Saves new movie with details cinema name and timing
	 */
	@PostMapping("/save")
	public ResponseEntity<Event> saveMovie(@RequestBody Event event){
		return new ResponseEntity<Event>(eventServiceImpl.saveMovie(event), HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param movieName
	 * Gets details of movie
	 */
	@GetMapping("/movieDetails")
	public List<Event> getMovieDetailsList(@RequestParam String movieName){
		List<Event> eventList = null;
		
		try {
			eventList = eventServiceImpl.getMovieDetailsList(movieName);

			if (eventList == null || eventList.isEmpty())
				throw new ResourceNotFoundException("Movie list", movieName, movieName);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Movie list", movieName, movieName);
		}
		
		return eventList;
	}
}
