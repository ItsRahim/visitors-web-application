package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

//!TODO: Find a way to remove the need of the table mapping
@Data
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "visitor_id")
//    private Visitor visitor;
//
//    @OneToOne
//    @JoinColumn(name = "resident_id")
//    private Resident resident;
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;
    @Column(name = "start_time")
    private LocalDateTime bookingStartTime;

    @Column(name = "end_time")
    private LocalDateTime bookingEndTime;

    @Column(name = "status")
    private BookingStatus bookingStatus = BookingStatus.PENDING;
}
