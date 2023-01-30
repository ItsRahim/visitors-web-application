package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
    Employee getEmployee(Long id);
    Collection<Employee> listAll();
}
