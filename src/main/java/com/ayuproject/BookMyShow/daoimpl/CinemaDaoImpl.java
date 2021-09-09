package com.ayuproject.BookMyShow.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayuproject.BookMyShow.dao.CinemaDao;
import com.ayuproject.BookMyShow.model.Event;
import com.ayuproject.BookMyShow.model.TicketDetails;

@Repository
public class CinemaDaoImpl implements CinemaDao{
	private EntityManager entityManager;
	
	@Autowired
	public CinemaDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
