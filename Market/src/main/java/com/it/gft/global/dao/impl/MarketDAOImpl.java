package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.MarketDAO;
import com.it.gft.global.model.Market;

@Repository("marketDAO")
public class MarketDAOImpl extends AbstractDao implements MarketDAO {

    @Override
    public void save(Market client) {
	persist(client);
    }

    @Override
    public List<Market> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(Market.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<Market>) criteria.list();
    }

    @Override
    public void deleteById(Integer id) {
	Query query = getSession().createSQLQuery("delete from Client where client_id = :client_id");
	query.setInteger("client_id", id);
	query.executeUpdate();
    }

    @Override
    public void update(Market client) {
	merge(client);
    }

    @Override
    public void delete(Market client) {
	getSession().delete(client);
    }

    @Override
    public Market findById(Integer id) {
	Criteria criteria = getSession().createCriteria(Market.class);
	criteria.add(Restrictions.eq("client_id", id));
	return (Market) criteria.uniqueResult();
    }
}
