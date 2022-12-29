package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    @OneToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;
    private LocalDateTime bookingTime;
    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;
    private BookingStatus bookingStatus = BookingStatus.PENDING;
}
