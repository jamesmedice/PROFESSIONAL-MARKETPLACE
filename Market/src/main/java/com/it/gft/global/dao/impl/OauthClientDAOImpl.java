package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.OauthClientDAO;
import com.it.gft.global.model.OauthClient;

/**
 * 
 * @author TOSS
 *
 */
@Repository("oauthClientDAO")
public class OauthClientDAOImpl extends AbstractDao implements OauthClientDAO {

    @Override
    public void save(OauthClient entity) {
	persist(entity);
    }

    @Override
    public List<OauthClient> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(OauthClient.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<OauthClient>) criteria.list();
    }

    @Override
    public void deleteById(String id) {
	Query query = getSession().createSQLQuery("delete from OauthClient where client_id = :client_id");
	query.setString("client_id", id);
	query.executeUpdate();
    }

    @Override
    public void update(OauthClient entity) {
	merge(entity);
    }

    @Override
    public void delete(OauthClient entity) {
	remove(entity);
    }

    @Override
    public OauthClient findById(String id) {
	Criteria criteria = getSession().createCriteria(OauthClient.class);
	criteria.add(Restrictions.eq("client_id", id));
	return (OauthClient) criteria.uniqueResult();
    }

}
