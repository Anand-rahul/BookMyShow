package com.java.bms.Service;

import com.java.bms.Enums.SeatCategory;
import com.java.bms.Model.*;
import com.java.bms.Repository.BookingRepository;
import com.java.bms.Repository.SeatRepository;
import com.java.bms.Repository.ShowRepository;
import com.java.bms.Repository.UserRepository;
import com.java.bms.dto.BookingRequest;
import com.java.bms.dto.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final StampedLock stampedLock = new StampedLock();
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

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
                booking.getBookedSeats().stream().map(Seat::getId).toList(),
                user.getMobile(),
                booking.getStatus(),
                String.valueOf(show.getShowStartTime()),
                show.getMovie().getMovieDurationInMinutes()
        );
    }
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Booking createBooking(BookingRequest bookingRequest) throws InterruptedException {
        int maxRetries = 3;
        int attempts = 0;

        while (attempts < maxRetries) {
            // Get an optimistic read stamp
            long stamp = stampedLock.tryOptimisticRead();
            try {
                Booking booking = tryCreateBooking(bookingRequest, stamp);
                // Validate if the stamp is still valid
                if (stampedLock.validate(stamp)) {
                    return booking;
                }
            } catch (Exception e) {
                attempts++;
                if (attempts == maxRetries) {
                    throw new RuntimeException("Unable to create booking due to concurrent modifications. Please try again.");
                }
                // Add small random delay before retry
                Thread.sleep((long) (Math.random() * 1000));
            }
        }
        throw new RuntimeException("Booking creation failed after " + maxRetries + " attempts");
    }

    private Booking tryCreateBooking(BookingRequest bookingRequest, long stamp) {
        // First attempt with optimistic read
        Show show = showRepository.findById(bookingRequest.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        List<Seat> allSeats = show.getScreen().getSeats();
        List<Integer> availableSeatIds = allSeats.stream()
                .map(Seat::getId)
                .toList();

        // Validate seat existence
        List<Integer> requestedSeats = bookingRequest.getSeatIds();
        validateSeatExistence(requestedSeats, availableSeatIds);

        // If the stamp is no longer valid, convert to write lock
        if (!stampedLock.validate(stamp)) {
            // Release optimistic read and acquire write lock
            long writeLock = stampedLock.writeLock();
            try {
                // Re-validate everything under write lock
                show = showRepository.findById(bookingRequest.getShowId())
                        .orElseThrow(() -> new RuntimeException("Show not found"));
                validateSeatExistence(requestedSeats, availableSeatIds);

                return processBookingUnderLock(show, requestedSeats, bookingRequest);
            } finally {
                stampedLock.unlockWrite(writeLock);
            }
        }

        // If stamp is still valid, proceed with optimistic read
        return processBookingUnderLock(show, requestedSeats, bookingRequest);
    }

    private void validateSeatExistence(List<Integer> requestedSeats, List<Integer> availableSeatIds) {
        for (Integer seatId : requestedSeats) {
            if (!availableSeatIds.contains(seatId)) {
                throw new RuntimeException("Seat " + seatId + " does not exist in the screen.");
            }
        }
    }

    private Booking processBookingUnderLock(Show show, List<Integer> requestedSeats,
                                            BookingRequest bookingRequest) {
        // Fetch and validate seats
        List<Seat> selectedSeats = seatRepository.findAllById(requestedSeats);
        for (Seat seat : selectedSeats) {
            if (seat.isBooked()) {
                throw new RuntimeException("Seat " + seat.getId() + " is already booked.");
            }
        }

        // Calculate payment
        double totalAmount = selectedSeats.stream()
                .mapToDouble(seat -> getSeatPrice(seat.getSeatCategory()))
                .sum();

        try {
            // Simulate payment processing
            Thread.sleep(60000);

            // Mark seats as booked
            selectedSeats.forEach(seat -> seat.setBooked(true));
            seatRepository.saveAll(selectedSeats);

            show.getBookedSeatIds().addAll(requestedSeats);
            showRepository.save(show);

            // Fetch user and create booking
            User user = userRepository.findById(bookingRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Booking booking = new Booking();
            booking.setShow(show);
            booking.setUser(user);
            booking.setBookedSeats(selectedSeats);
            booking.setStatus("SUCCESS");

            return bookingRepository.save(booking);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Booking process was interrupted");
        }
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
                booking.getBookedSeats().stream().map(Seat::getId).collect(Collectors.toList()),
                user.getMobile(),
                booking.getStatus(),
                String.valueOf(show.getShowStartTime()),
                show.getMovie().getMovieDurationInMinutes()
        );
    }
}

