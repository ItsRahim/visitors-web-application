package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Booking {
    @Id
    @NonNull
    private Long id;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;


    @NonNull
    @OneToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

    @NonNull
    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Nullable
    @Column(name = "start_time")
    private LocalDateTime bookingStartTime;

    @Nullable
    @Column(name = "end_time")
    private LocalDateTime bookingEndTime;

    @NonNull
    @Column(name = "status")
    private BookingStatus bookingStatus = BookingStatus.PENDING;

}
