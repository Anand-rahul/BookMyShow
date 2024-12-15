package com.java.bms.Service;

import com.java.bms.Model.Seat;
import com.java.bms.Model.Show;
import com.java.bms.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    /*public List<Show> getShowsByMovieIdAndCity(int movieId, String city) {
        return showRepository.findShowsByMovieIdAndCity(movieId, city);
    }*/

    public List<Seat> getAvailableSeats(int showId) {
        // Fetch the show by ID
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        // Get all seats linked to the screen
        List<Seat> allSeats = show.getScreen().getSeats();

        // Filter out already booked seats
        List<Integer> bookedSeatIds = show.getBookedSeatIds();
        return allSeats.stream()
                .filter(seat -> !bookedSeatIds.contains(seat.getSeatId()))
                .collect(Collectors.toList());
    }
}
