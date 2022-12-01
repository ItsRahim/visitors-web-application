package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public Employee updateEmployee(Employee emp, String id) {
        Employee toUpdate = employeeRepo.findByIdOrError(id);
        toUpdate.setFirstName(emp.getFirstName());
        toUpdate.setLastName(emp.getLastName());
        toUpdate.setDob(emp.getDob());
        toUpdate.setEmail(emp.getEmail());
        toUpdate.setStartDate(emp.getStartDate());
        toUpdate.setRole(emp.getRole());
        return employeeRepo.save(toUpdate);
    }

    @Override
    public void deleteEmployee(String id) {
        boolean exists = employeeRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with ID " + id + " does not exist");
        }employeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmployee(String id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Collection<Employee> listAll(int limit) {
        return employeeRepo.findAll(PageRequest.of(0, limit)).toList();
    }
}
