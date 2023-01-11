package com.rahim.visitorswebapplication.repository;

import com.rahim.visitorswebapplication.model.Booking;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    default Booking findByIdOrError(String id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Modifying
    @Query("DELETE FROM Booking b WHERE b.id = ?1")
    void deleteByBookingId(String Id);
}
