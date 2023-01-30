package com.rahim.visitorswebapplication.dto;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    private VisitorDto visitor;
    private ResidentDto resident;
    private LocalDateTime bookingTime;
    private BookingStatus bookingStatus;
}
