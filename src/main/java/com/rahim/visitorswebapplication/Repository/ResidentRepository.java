package com.rahim.visitorswebapplication.Repository;

import com.rahim.visitorswebapplication.Entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, String> {
}
