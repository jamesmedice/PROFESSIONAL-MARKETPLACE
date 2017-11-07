package com.it.gft.global.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.it.gft.global.dao.AbstractDao;
import com.it.gft.global.dao.ProjectDAO;
import com.it.gft.global.model.Project;

@Repository("projectDAO")
public class ProjectDAOImpl extends AbstractDao implements ProjectDAO {

    @Override
    public void update(Project entity) {
	merge(entity);
    }

    @Override
    public void delete(Project entity) {
	remove(entity);
    }

    @Override
    public void save(Project entity) {
	persist(entity);
    }

    @Override
    public List<Project> findAll(Boolean orderBy, String name) {
	Criteria criteria = getSession().createCriteria(Project.class);

	if (orderBy)
	    if (name != null)
		criteria.addOrder(Order.asc(name));

	return (List<Project>) criteria.list();
    }

    @Override
    public void deleteById(Integer id) {
	Query query = getSession().createSQLQuery("delete from Project where project_id = :project_id");
	query.setInteger("project_id", id);
	query.executeUpdate();
    }

    @Override
    public Project findById(Integer id) {
	Criteria criteria = getSession().createCriteria(Project.class);
	criteria.add(Restrictions.eq("project_id", id));
	return (Project) criteria.uniqueResult();
    }

}
