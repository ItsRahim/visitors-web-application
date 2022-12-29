package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
}
