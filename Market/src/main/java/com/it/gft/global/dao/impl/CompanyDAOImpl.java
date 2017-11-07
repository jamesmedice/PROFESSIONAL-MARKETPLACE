package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.CompanyDAO;
import com.it.gft.global.model.Company;

@Repository("companyDAO")
public class CompanyDAOImpl extends AbstractDao implements CompanyDAO {

    @Override
    public void save(Company entity) {
	persist(entity);
    }

    @Override
    public List<Company> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(Company.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<Company>) criteria.list();
    }

    @Override
    public void deleteById(Integer id) {
	Query query = getSession().createSQLQuery("delete from Company where company_id = :company_id");
	query.setInteger("company_id", id);
	query.executeUpdate();
    }

    @Override
    public void update(Company entity) {
	merge(entity);

    }

    @Override
    public void delete(Company entity) {
	remove(entity);
    }

    @Override
    public Company findById(Integer id) {
	Criteria criteria = getSession().createCriteria(Company.class);
	criteria.add(Restrictions.eq("company_id", id));
	return (Company) criteria.uniqueResult();
    }

}
