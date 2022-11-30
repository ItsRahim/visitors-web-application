package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.service.implementation.EmployeeServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImplementation employeeService;

    @GetMapping("/list")
    public Collection<Employee> listAll() {
        return employeeService.listAll(10);
    }
}
