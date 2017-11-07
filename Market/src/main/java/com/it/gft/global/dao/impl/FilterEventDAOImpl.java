package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.FilterEventDAO;
import com.it.gft.global.model.FilterEvent;

@Repository("filterEventDAO")
public class FilterEventDAOImpl extends AbstractDao implements FilterEventDAO {

    public void save(FilterEvent filterEvent) {
	persist(filterEvent);
    }

    public List<FilterEvent> findAll() {
	Criteria criteria = getSession().createCriteria(FilterEvent.class);
	return (List<FilterEvent>) criteria.list();
    }

    public FilterEvent findById(Integer id) {
	Criteria criteria = getSession().createCriteria(FilterEvent.class);
	criteria.add(Restrictions.eq("id", id));
	return (FilterEvent) criteria.uniqueResult();
    }

    public void update(FilterEvent filterEvent) {
	getSession().update(filterEvent);
    }

}
