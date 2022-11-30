package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.model.Employee;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(String id,
                            String firstName,
                            String lastName,
                            LocalDate dob,
                            String email,
                            LocalDate startDate,
                            EmployeeRole role);
    void deleteEmployee(String id);
    Optional<Employee> getEmployee(String id);
    Collection<Employee> listAll(int limit);
}
