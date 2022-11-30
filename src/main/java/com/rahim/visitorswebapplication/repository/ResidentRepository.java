package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String> {
}
