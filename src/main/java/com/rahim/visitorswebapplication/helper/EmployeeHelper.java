package com.rahim.visitorswebapplication.helper;

import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class EmployeeHelper {
    private final EmployeeRepository employeeRepository;
    private String emailFormatter(String firstName, String lastName) {
        return MessageFormat.format("{0}.{1}@bupa.com", firstName, lastName).toLowerCase();
    }

    /*
    TODO: Revise this approach for checking if email exists - only accounts for a pair of duplicates and not more
     */
    public String checkEmailExists(String firstName, String lastName) {
        String email = emailFormatter(firstName, lastName);
        return employeeRepository.existsByEmail(email) ? emailFormatter(firstName, lastName+1) : email;
    }
}
