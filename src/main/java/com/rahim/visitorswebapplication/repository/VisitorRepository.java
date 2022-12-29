package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Visitor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, String> {

    default Visitor findByIdOrError(String id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Modifying
    @Transactional
    @Query("DELETE FROM Visitor v WHERE v.id = ?1")
    void deleteByVisitorId(String Id);
}
