package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Booking;

import java.util.Collection;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking updateBooking(Booking booking, String id);
    void deleteBooking(String id);
    Booking getBooking(String id);
    Booking processBooking(String id);
    Collection<Booking> listAll(int limit);
}
