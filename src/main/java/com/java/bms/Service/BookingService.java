package com.java.bms.Service;

import com.java.bms.Model.Booking;
import com.java.bms.Model.Seat;
import com.java.bms.Model.Show;
import com.java.bms.Model.User;
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

        // Validate Seat Availability
        List<Integer> requestedSeats = bookingRequest.getSeatIds();
        List<Integer> bookedSeats = show.getBookedSeatIds();

        for (Integer seatId : requestedSeats) {
            if (bookedSeats.contains(seatId)) {
                throw new RuntimeException("Seat " + seatId + " is already booked");
            }
        }

        // Mark seats as booked
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

        // Map seat IDs to Seat objects
        List<Seat> seats = show.getScreen().getSeats().stream()
                .filter(seat -> requestedSeats.contains(seat.getSeatId()))
                .collect(Collectors.toList());
        booking.setBookedSeats(seats);
        booking.setStatus("SUCCESS");

        return bookingRepository.save(booking);
    }
}

