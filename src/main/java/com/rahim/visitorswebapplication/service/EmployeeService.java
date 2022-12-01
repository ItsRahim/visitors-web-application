package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Employee;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee, String id);
    void deleteEmployee(String id);
    Optional<Employee> getEmployee(String id);
    Collection<Employee> listAll(int limit);
}
