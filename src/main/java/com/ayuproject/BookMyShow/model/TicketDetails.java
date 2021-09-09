package com.ayuproject.BookMyShow.model;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author danrawat
 * 
 */
@Entity
@Table(name="ticket_details")
public class TicketDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="seat_number")
	private String seatNumber;
	
	@Column(name="seat_type")
	private String seatType;
	
	@Column(name="availability")
	private Boolean availability;
	
	@Column(name="cost")
	private int cost;
	
	@Column(name="seat_selected_time")
	private Timestamp seatSelectedTime;
	
	public TicketDetails() {
	}

	public TicketDetails(int eventId, String seatNumber, String seatType, Boolean availability, int cost) {
		this.eventId = eventId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.availability = availability;
		this.cost = cost;
	}

	public TicketDetails(int id, int eventId, String seatNumber, String seatType, Boolean availability, int cost) {
		this.id = id;
		this.eventId = eventId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.availability = availability;
		this.cost = cost;
	}
	
	public TicketDetails(int id, int eventId, String seatNumber, String seatType, 
			Boolean availability, int cost, Object seatSelectedTime) {
		this.id = id;
		this.eventId = eventId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.availability = availability;
		this.cost = cost;
		this.seatSelectedTime = (Timestamp) seatSelectedTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Boolean getAvailability() {
		if(availability == null) {
			availability = true;
		}
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Timestamp getSeatSelectedTime() {
		return seatSelectedTime;
	}

	public void setSeatSelectedTime(Timestamp seatSelectedTime) {
		this.seatSelectedTime = seatSelectedTime;
	}

	@Override
	public String toString() {
		return "TicketDetails [id=" + id + ", eventId=" + eventId + ", seatNumber=" + seatNumber + ", seatType="
				+ seatType + ", availability=" + availability + ", cost=" + cost + "]";
	}
	
	
}
