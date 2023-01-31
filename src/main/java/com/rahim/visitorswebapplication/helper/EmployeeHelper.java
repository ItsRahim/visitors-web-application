package com.rahim.visitorswebapplication.helper;

import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EmployeeHelper {
    private final EmployeeRepository employeeRepository;

    public String generateEmail(String firstName, String lastName) {
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@bupa.com";
        int counter = 1;
        while (employeeRepository.findByEmail(email)) {
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + counter + "@bupa.com";
            counter++;
        }
        return email;
    }
}
