package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.dto.BookingDto;
import com.rahim.visitorswebapplication.model.Booking;
import com.rahim.visitorswebapplication.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BookingDto> listAll() {
        return bookingService.listAll().stream()
                .map(Booking -> modelMapper.map(Booking, BookingDto.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable String id) {
        Booking booking = bookingService.getBooking(id);
        return modelMapper.map(booking, BookingDto.class);
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
