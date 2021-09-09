package com.ayuproject.BookMyShow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author danrawat
 *	Using a generic Event class. It can be extended for any events like Cricket matches, concerts, movie shows
 */
@Entity
@Table(name="event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_place")
	private String eventPlace;
	
	@Column(name="event_time")
	private String eventTime;
	
	public Event() {
	}
	
	public Event(String eventName, String eventPlace, String eventTime) {
		this.eventName = eventName;
		this.eventPlace = eventPlace;
		this.eventTime = eventTime;
	}
	
	
	public Event(int id, String eventName, String eventPlace, String eventTime) {
		this.id = id;
		this.eventName = eventName;
		this.eventPlace = eventPlace;
		this.eventTime = eventTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "Show Name: " + eventName + ", Show Timing: " + eventTime;
	}
	
}
