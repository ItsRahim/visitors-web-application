package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(String id) {
        return null;
    }

    @Override
    public Optional<Boolean> deleteEmployee(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> getEmployee(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Employee> listAll(int limit) {
        return null;
    }
}
