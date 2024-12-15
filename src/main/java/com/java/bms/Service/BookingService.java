package com.java.bms.Service;

import com.java.bms.Enums.SeatCategory;
import com.java.bms.Model.*;
import com.java.bms.Repository.BookingRepository;
import com.java.bms.Repository.ShowRepository;
import com.java.bms.Repository.UserRepository;
import com.java.bms.dto.BookingRequest;
import com.java.bms.dto.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public BookingResponse getBookingDetails(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Show show = booking.getShow();
        User user = booking.getUser();

        return new BookingResponse(
                booking.getId(),
                show.getMovie().getMovieName(),
                show.getScreen().getScreenId(),
                show.getScreen().getSeats().get(0).getSeatCategory().name(),
                booking.getBookedSeats().stream().map(Seat::getSeatId).toList(),
                user.getMobile(),
                booking.getStatus(),
                String.valueOf(show.getShowStartTime()),
                show.getMovie().getMovieDurationInMinutes()
        );
    }
    public Booking createBooking(BookingRequest bookingRequest) {
        // Fetch the Show
        Show show = showRepository.findById(bookingRequest.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        List<Seat> allSeats = show.getScreen().getSeats();
        List<Integer> availableSeatIds = allSeats.stream()
                .map(Seat::getSeatId)
                .collect(Collectors.toList());

        // Validate Requested Seat IDs
        List<Integer> requestedSeats = bookingRequest.getSeatIds();
        for (Integer seatId : requestedSeats) {
            if (!availableSeatIds.contains(seatId)) {
                throw new RuntimeException("Seat " + seatId + " does not exist in the screen.");
            }
        }

        // Check if any seat is already booked
        List<Integer> bookedSeats = show.getBookedSeatIds();
        List<Integer> alreadyBookedSeats = requestedSeats.stream()
                .filter(bookedSeats::contains)
                .collect(Collectors.toList());

        if (!alreadyBookedSeats.isEmpty()) {
            throw new RuntimeException("Seats already booked: " + alreadyBookedSeats);
        }

        // Calculate Payment Amount
        double totalAmount = allSeats.stream()
                .filter(seat -> requestedSeats.contains(seat.getSeatId()))
                .mapToDouble(seat -> getSeatPrice(seat.getSeatCategory()))
                .sum();

        // **Integrate Payment Gateway** (Placeholder for Razorpay)
        /*Payment payment = initiatePayment(totalAmount, bookingRequest);

        if (!payment.isPaymentSuccessful()) {
            throw new RuntimeException("Payment failed. Please try again.");
        }*/

        // Mark seats as booked after successful payment
        bookedSeats.addAll(requestedSeats);
        show.setBookedSeatIds(bookedSeats);
        showRepository.save(show);

        // Fetch the User
        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create Booking Entity
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setUser(user);
        booking.setBookedSeats(allSeats.stream()
                .filter(seat -> requestedSeats.contains(seat.getSeatId()))
                .collect(Collectors.toList()));
        booking.setStatus("SUCCESS");
        //booking.setPayment(payment);

        return bookingRepository.save(booking);
    }
    public List<BookingResponse> getAllBookingDetails() {
        List<Booking> bookingList = bookingRepository.findAll();

        // Convert Booking to BookingResponse
        return bookingList.stream().map(this::mapToBookingResponse).collect(Collectors.toList());
    }
    private double getSeatPrice(SeatCategory seatCategory) {
        switch (seatCategory) {
            case SILVER:
                return 100.0;
            case GOLD:
                return 200.0;
            case PLATINUM:
                return 300.0;
            default:
                throw new IllegalArgumentException("Invalid seat category");
        }
    }
    private BookingResponse mapToBookingResponse(Booking booking) {
        Show show = booking.getShow();
        User user = booking.getUser();

        return new BookingResponse(
                booking.getId(),
                show.getMovie().getMovieName(),
                show.getScreen().getScreenId(),
                show.getScreen().getSeats().get(0).getSeatCategory().name(),
                booking.getBookedSeats().stream().map(Seat::getSeatId).collect(Collectors.toList()),
                user.getMobile(),
                booking.getStatus(),
                String.valueOf(show.getShowStartTime()),
                show.getMovie().getMovieDurationInMinutes()
        );
    }
}

