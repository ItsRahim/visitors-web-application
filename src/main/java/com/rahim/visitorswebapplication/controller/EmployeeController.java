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

    /*
    localhost:8080/api/v2/employee/METHOD
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<Employee> listAll() {
        return employeeService.listAll(10);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable String id) {
        return employeeService.updateEmployee(emp, id);
    }
}
