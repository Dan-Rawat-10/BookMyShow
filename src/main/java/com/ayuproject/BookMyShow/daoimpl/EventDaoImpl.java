package com.ayuproject.BookMyShow.daoimpl;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayuproject.BookMyShow.dao.EventDao;
import com.ayuproject.BookMyShow.model.Event;

@Repository
public class EventDaoImpl implements EventDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EventDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	@Override
	public Event saveEvent(Event event) {
		Session entitySession = entityManager.unwrap(Session.class);
		entitySession.save(event);
		return event;
	}
	
	@Transactional
	@Override
	public List<Event> getMovieDetailsListByMovieName(String movieName) {
		Session entitySession = entityManager.unwrap(Session.class);
		String queryString = "Select NEW com.ayuproject.BookMyShow.model.Event(e.id, e.eventName, e.eventPlace, e.eventTime) "
				+ "from Event e where e.eventName = :movieName";
		Query query = entitySession.createQuery(queryString);
		query.setParameter("movieName", movieName);
		List<Event> resultList = (ArrayList<Event>) query.getResultList();
		return resultList;
	}
	
	@Transactional
	public List<Event> getMovieDetailsListByCinemaName(String cinema) {
		Session entitySession = entityManager.unwrap(Session.class);
		String queryString = "Select NEW com.ayuproject.BookMyShow.model.Event(e.id, e.eventName, e.eventPlace, e.eventTime) "
				+ "from Event e where e.eventPlace = :cinema";
		Query query = entitySession.createQuery(queryString);
		query.setParameter("cinema", cinema);
		List<Event> resultList = (ArrayList<Event>) query.getResultList();
		return resultList;
	}
}
