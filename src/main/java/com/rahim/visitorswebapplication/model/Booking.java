package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    private LocalDateTime bookingTime;
    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;
    private BookingStatus bookingStatus = BookingStatus.PENDING;
}
