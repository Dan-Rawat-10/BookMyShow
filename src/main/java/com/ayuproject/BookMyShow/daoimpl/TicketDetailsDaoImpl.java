package com.ayuproject.BookMyShow.daoimpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayuproject.BookMyShow.dao.TicketDetailsDao;
import com.ayuproject.BookMyShow.model.TicketDetails;

@Repository
public class TicketDetailsDaoImpl implements TicketDetailsDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public TicketDetailsDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public TicketDetails getTicketDetails(int id, String seatName) {
		Session entitySession = entityManager.unwrap(Session.class);
		String queryString = "Select NEW com.ayuproject.BookMyShow.model.TicketDetails(t.id, t.eventId, t.seatNumber, t.seatType, t.availability, t.cost) "
				+ "from TicketDetails t where t.id = :id and t.seatNumber = :seatName";
		Query query = entitySession.createQuery(queryString);
		query.setParameter("id", id);
		query.setParameter("seatName", seatName);
		TicketDetails ticketDetails = (TicketDetails) query.getSingleResult();
		return ticketDetails;
	}
	
	@Transactional
	public TicketDetails updateTimeStampOfTicketDetails(int id, TicketDetails ticketDetails) {
		Session entitySession = entityManager.unwrap(Session.class);
		String updateString = "Update TicketDetails set seatSelectedTime = :seatSelectedTime where id = :id";
		Query query = entitySession.createQuery(updateString);
		Timestamp timestamp =  new java.sql.Timestamp(new java.util.Date().getTime());
		ticketDetails.setSeatSelectedTime(timestamp);
		query.setParameter("seatSelectedTime", timestamp);
		query.setParameter("id", id);
		query.executeUpdate();
		return ticketDetails;
	}
	
	@Transactional
	public TicketDetails updateAvailabilityOfBoughtTicket(int id, TicketDetails ticketDetails) {
		Session entitySession = entityManager.unwrap(Session.class);
		String updateString = "Update TicketDetails set availability = :availability where id = :id";
		Query query = entitySession.createQuery(updateString);
		boolean availability = false;
		ticketDetails.setAvailability(availability);
		query.setParameter("availability", availability);
		query.setParameter("id", id);
		query.executeUpdate();
		return ticketDetails;
	}
	
	@Transactional
	public List<TicketDetails> getTicketDetailsListByEventId(int eventId) {
		Session entitySession = entityManager.unwrap(Session.class);
		String queryString = "Select NEW com.ayuproject.BookMyShow.model.TicketDetails(t.id, t.eventId, t.seatNumber, t.seatType, t.availability, t.cost, t.seatSelectedTime) "
				+ "from TicketDetails t where t.eventId = :eventId";
		Query query = entitySession.createQuery(queryString);
		query.setParameter("eventId", eventId);
		List<TicketDetails> ticketDetailsList = (ArrayList<TicketDetails>) query.getResultList();
		return ticketDetailsList;
	}
}
