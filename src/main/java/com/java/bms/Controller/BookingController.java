package com.java.bms.Controller;

import com.java.bms.Model.Booking;
import com.java.bms.Service.BookingService;
import com.java.bms.dto.BookingRequest;
import com.java.bms.dto.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
    @GetMapping("/{bookingId}")
    public BookingResponse getBookingDetailsById(@PathVariable Long bookingId) {
        return bookingService.getBookingDetails(bookingId);
    }
    @GetMapping
    public List<BookingResponse> getAllBookingDetails(){
        return bookingService.getAllBookingDetails();
    }
}
