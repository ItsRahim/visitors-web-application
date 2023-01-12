package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.model.Booking;
import com.rahim.visitorswebapplication.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<Booking> listAll() {
        return bookingService.listAll(10);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable String id) {
        return bookingService.getBooking(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Booking updateBooking(@RequestBody Booking booking, @PathVariable String id) {
        return bookingService.updateBooking(booking, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/process/{id}")
    public Booking processBooking(@PathVariable String id) {
        return bookingService.processBooking(id);
    }
}
