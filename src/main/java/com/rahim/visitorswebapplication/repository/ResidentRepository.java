package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Resident;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    default Resident findByIdOrError(Long id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Modifying
    @Transactional
    @Query("DELETE FROM Resident e WHERE e.id = ?1")
    void deleteByResidentId(Long Id);
}
