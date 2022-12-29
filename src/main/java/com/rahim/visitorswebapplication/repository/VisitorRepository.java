package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, String> {
}
