package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    default Employee findByIdOrError(String id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
