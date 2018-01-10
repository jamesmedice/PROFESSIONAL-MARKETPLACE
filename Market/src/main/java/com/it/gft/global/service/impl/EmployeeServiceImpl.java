package com.it.gft.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.EmployeeDAO;
import com.it.gft.global.model.Employee;
import com.it.gft.global.service.EmployeeService;

/**
 * 
 * @author TOSS
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired(required = true)
    private EmployeeDAO employeeDAO;

    @Override
    public void saveEmployee(Employee client) {
	employeeDAO.save(client);
    }

    @Override
    public List<Employee> findAllEmployees(Boolean orderBy, String name) {
	return employeeDAO.findAll(orderBy, name);
    }

    @Override
    public List<Employee> findAllEmployees() {
	return employeeDAO.findAll(false, null);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
	employeeDAO.deleteById(id);
    }

    @Override
    public void deleteEmployee(Employee client) {
	employeeDAO.delete(client);
    }

    @Override
    public Employee findById(Integer id) {
	return employeeDAO.findById(id);
    }

    @Override
    public void updateEmployee(Employee client) {
	employeeDAO.update(client);
    }

}
