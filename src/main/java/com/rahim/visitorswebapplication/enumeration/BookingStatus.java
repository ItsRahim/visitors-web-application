package com.rahim.visitorswebapplication.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BookingStatus {
    PENDING,
    ACTIVE,
    COMPLETE;

    @Getter
    public String bookingStatus;
}
