package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.ProfileDAO;
import com.it.gft.global.model.Profile;

/**
 * 
 * @author TOSS
 *
 */
@Repository("profileDAO")
public class ProfileDAOImpl extends AbstractDao implements ProfileDAO {

    @Override
    public void save(Profile entity) {
	persist(entity);
    }

    @Override
    public List<Profile> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(Profile.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<Profile>) criteria.list();
    }

    @Override
    public void deleteById(Integer id) {
	Query query = getSession().createSQLQuery("delete from Profile where profile_id = :profile_id");
	query.setInteger("profile_id", id);
	query.executeUpdate();
    }

    @Override
    public void update(Profile entity) {
	merge(entity);
    }

    @Override
    public void delete(Profile entity) {
	remove(entity);
    }

    @Override
    public Profile findById(Integer id) {
	Criteria criteria = getSession().createCriteria(Profile.class);
	criteria.add(Restrictions.eq("profile_id", id));
	return (Profile) criteria.uniqueResult();
    }

}
