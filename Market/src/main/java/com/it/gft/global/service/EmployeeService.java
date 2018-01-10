package com.it.gft.global.service;

import java.util.List;

import com.it.gft.global.model.Employee;

public interface EmployeeService {

    void saveEmployee(Employee client);

    List<Employee> findAllEmployees(Boolean orderBy, String name);

    List<Employee> findAllEmployees();

    void deleteEmployeeById(Integer id);

    void deleteEmployee(Employee employee);

    Employee findById(Integer id);

    void updateEmployee(Employee employee);
}
