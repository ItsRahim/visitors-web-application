package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public Collection<Employee> listAll() {
        return employeeService.listAll(10);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
