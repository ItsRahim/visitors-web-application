package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    default Employee findByIdOrError(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = ?1")
    void deleteByEmployeeId(Long Id);

    Optional<Employee> findByEmail(String email);
}
