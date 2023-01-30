package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, String id);
    void deleteEmployee(String id);
    Employee getEmployee(String id);
    Collection<Employee> listAll();
}
