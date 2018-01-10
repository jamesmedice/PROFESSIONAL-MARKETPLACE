package com.it.gft.global.dao;

import java.util.List;

import com.it.gft.global.model.Employee;

public interface EmployeeDAO extends BaseDAO<Employee> {

    void save(Employee entity);

    void deleteById(Integer id);

    void update(Employee entity);

    void delete(Employee entity);

    List<Employee> findAll(Boolean orderBy, String name);

    Employee findById(Integer id);
}
