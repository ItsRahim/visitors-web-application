package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.dto.EmployeeDto;
import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    /*
    localhost:8080/api/v2/employee/METHOD
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<EmployeeDto> listAll() {
        return employeeService.listAll().stream()
                .map(Employee -> modelMapper.map(Employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployee(id);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
        return employeeService.updateEmployee(emp, id);
    }
}
