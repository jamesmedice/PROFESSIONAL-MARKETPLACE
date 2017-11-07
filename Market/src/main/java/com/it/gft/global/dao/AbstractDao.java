package com.it.gft.global.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
	getSession().persist(entity);
    }

    public void merge(Object entity) {
	getSession().merge(entity);
    }

    public void remove(Object entity) {
	getSession().delete(entity);
    }
}