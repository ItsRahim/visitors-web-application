package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.repository.EmployeeRepository;
import com.rahim.visitorswebapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    @Override

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee emp, Long id) {
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
    public void deleteEmployee(Long id) {
        employeeRepo.deleteByEmployeeId(id);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Employee> listAll() {
        return employeeRepo.findAll();
    }
}
