package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
@NoArgsConstructor
public class Booking {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "start_time")
    private LocalDateTime bookingStartTime;

    @Column(name = "end_time")
    private LocalDateTime bookingEndTime;

    @Column(name = "status")
    private BookingStatus bookingStatus;

    public Booking(Visitor visitor, Resident resident, LocalDateTime bookingTime) {
        this.id = UUID.randomUUID().toString();
        this.visitor = visitor;
        this.resident = resident;
        this.bookingTime = bookingTime;
        this.bookingStatus = BookingStatus.PENDING;
    }
}
