package com.rahim.visitorswebapplication.helper;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;
import java.util.Optional;

@RequiredArgsConstructor
public class EmployeeHelper {
    private final EmployeeRepository employeeRepository;

    private String emailFormatter(String firstName, String lastName) {
        return MessageFormat.format("{0}.{1}@bupa.com", firstName, lastName).toLowerCase();
    }

    /*
    TODO: Revise this approach for checking if email exists - only accounts for a pair of duplicates and not more
     */
    public String generateEmail(String firstName, String lastName) {
        String email = emailFormatter(firstName, lastName);
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        return employee.isPresent() ? emailFormatter(firstName, lastName + 1) : email;
    }
}
