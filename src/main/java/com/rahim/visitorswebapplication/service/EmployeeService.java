package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(String id);
    Optional<Boolean> deleteEmployee(String id);
    Optional<Employee> getEmployee(String id);
    Collection<Employee> listAll(int limit);
}
