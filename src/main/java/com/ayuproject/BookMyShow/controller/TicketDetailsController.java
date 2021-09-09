package com.ayuproject.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayuproject.BookMyShow.exception.ResourceNotFoundException;
import com.ayuproject.BookMyShow.model.TicketDetails;
import com.ayuproject.BookMyShow.serviceimpl.TicketDetailsServiceImpl;

@RestController
@RequestMapping("/api/ticketDetails")
public class TicketDetailsController {

	@Autowired
	TicketDetailsServiceImpl ticketDetailsServiceImpl;
	
	/**
	 * @param ticketDetailsId
	 * @param seatName
	 * Selects the seat requested by user
	 */
	@GetMapping("/selectSeat")
	public TicketDetails  selectSeat(@RequestParam int ticketDetailsId, @RequestParam String seatName) {
		TicketDetails ticketDetails = null;
		
		try {
			ticketDetails = ticketDetailsServiceImpl.selectSeat(ticketDetailsId, seatName);

			if (ticketDetails == null)
				throw new ResourceNotFoundException("Ticket details", ticketDetailsId + " " + seatName,
						ticketDetailsId + " " + seatName);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Ticket details", ticketDetailsId + " " + seatName,
					ticketDetailsId + " " + seatName);
		}

		return ticketDetails;
	}
	
	/**
	 * 
	 * @param ticketDetailsId
	 * @param seatName
	 * Buys the ticket requested by user
	 */
	@GetMapping("/buyTicket")
	public TicketDetails  buyTicket(@RequestParam int ticketDetailsId, @RequestParam String seatName) {
		TicketDetails ticketDetails = null;
		
		try {
			ticketDetails = ticketDetailsServiceImpl.buyTicket(ticketDetailsId, seatName);

			if (ticketDetails == null)
				throw new ResourceNotFoundException("Ticket details", ticketDetailsId + " " + seatName,
						ticketDetailsId + " " + seatName);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Ticket details", ticketDetailsId + " " + seatName,
					ticketDetailsId + " " + seatName);
		}

		return ticketDetails;
	}
}
