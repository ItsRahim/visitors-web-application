package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    default Employee findByIdOrError(String id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.id = ?1")
    void deleteByEmployeeId(String Id);
}
