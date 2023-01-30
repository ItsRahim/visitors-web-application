package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.enumeration.BookingStatus;
import com.rahim.visitorswebapplication.model.Booking;
import com.rahim.visitorswebapplication.repository.BookingRepository;
import com.rahim.visitorswebapplication.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BookingServiceImplementation implements BookingService {
    private final BookingRepository bookingRepository;
    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking, String id) {
        return null;
    }

    @Override
    public void deleteBooking(String id) {
        bookingRepository.deleteByBookingId(id);
    }

    @Override
    public Booking getBooking(String id) {
        return bookingRepository.findByIdOrError(id);
    }

    @Override
    public Booking processBooking(String id) {
        Booking booking = bookingRepository.findByIdOrError(id);
        BookingStatus status = booking.getBookingStatus();
        switch (status) {
            case PENDING -> {
                booking.setBookingStatus(BookingStatus.ACTIVE);
                booking.setBookingStartTime(LocalDateTime.now());
            }
            case ACTIVE -> {
                booking.setBookingStatus(BookingStatus.COMPLETE);
                booking.setBookingEndTime(LocalDateTime.now());
            }
            default -> log.info("Booking is already complete");
        }
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public Collection<Booking> listAll() {
        return bookingRepository.findAll();
    }
}
