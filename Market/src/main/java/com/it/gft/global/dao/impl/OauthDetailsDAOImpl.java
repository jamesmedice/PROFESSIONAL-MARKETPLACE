package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.OauthDetailsDAO;
import com.it.gft.global.model.OauthDetails;

/**
 * 
 * @author TOSS
 *
 */
@Repository("oauthDetailsDAO")
public class OauthDetailsDAOImpl extends AbstractDao implements OauthDetailsDAO {

    @Override
    public void save(OauthDetails entity) {
	persist(entity);
    }

    @Override
    public List<OauthDetails> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(OauthDetails.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<OauthDetails>) criteria.list();
    }

    @Override
    public void deleteById(String id) {
	Query query = getSession().createSQLQuery("delete from OauthDetails where username = :id");
	query.setString("id", id);
	query.executeUpdate();
    }

    @Override
    public void update(OauthDetails entity) {
	merge(entity);
    }

    @Override
    public void delete(OauthDetails entity) {
	remove(entity);
    }

    @Override
    public OauthDetails findById(String id) {
	Criteria criteria = getSession().createCriteria(OauthDetails.class);
	criteria.add(Restrictions.eq("username", id));
	return (OauthDetails) criteria.uniqueResult();
    }

}
