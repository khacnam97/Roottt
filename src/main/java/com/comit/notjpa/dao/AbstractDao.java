package com.comit.notjpa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.comit.notjpa.entities.Employee;

public abstract class AbstractDao {
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	protected List<?> find(String query) {
		return getCurrentSession().createQuery(query).list();
	}

	public Employee delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
