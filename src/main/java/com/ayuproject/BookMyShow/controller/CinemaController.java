package com.ayuproject.BookMyShow.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayuproject.BookMyShow.exception.ResourceNotFoundException;
import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.model.TicketDetails;
import com.ayuproject.BookMyShow.serviceimpl.CinemaServiceImpl;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
	
	@Autowired
	CinemaServiceImpl cinemaServiceImpl;
	
	/**
	 * @param cinema
	 * Returns the list of movies and their seat details for the given cinema name
	 */
	@GetMapping("/details")
	public Map<Event, List<TicketDetails>> getCinemaDetails(@RequestParam String cinema){
		Map<Event, List<TicketDetails>> eventTicketDetailsMap = null;
		
		try {
			eventTicketDetailsMap = cinemaServiceImpl.getCinemaDetails(cinema);

			if (eventTicketDetailsMap == null || eventTicketDetailsMap.isEmpty())
				throw new ResourceNotFoundException("CinemaDetails", cinema, cinema);
		} catch (Exception e) {
			throw new ResourceNotFoundException("CinemaDetails", cinema, cinema);
		}
		
		return eventTicketDetailsMap;
	}
}
