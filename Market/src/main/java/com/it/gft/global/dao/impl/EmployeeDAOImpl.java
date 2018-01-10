package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.EmployeeDAO;
import com.it.gft.global.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl extends AbstractDao implements EmployeeDAO {

    @Override
    public void save(Employee client) {
	persist(client);
    }

    @Override
    public List<Employee> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(Employee.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<Employee>) criteria.list();
    }

    @Override
    public void deleteById(Integer id) {
	Query query = getSession().createSQLQuery("delete from Employee where employee_id = :employee_id");
	query.setInteger("employee_id", id);
	query.executeUpdate();
    }

    @Override
    public void update(Employee client) {
	merge(client);
    }

    @Override
    public void delete(Employee client) {
	getSession().delete(client);
    }

    @Override
    public Employee findById(Integer id) {
	Criteria criteria = getSession().createCriteria(Employee.class);
	criteria.add(Restrictions.eq("employee_id", id));
	return (Employee) criteria.uniqueResult();
    }
}
