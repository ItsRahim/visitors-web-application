package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
}
