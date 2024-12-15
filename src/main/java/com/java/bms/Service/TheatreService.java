package com.java.bms.Service;

import com.java.bms.Model.Movie;
import com.java.bms.Model.Show;
import com.java.bms.Model.Theatre;
import com.java.bms.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public List<Theatre> fetchTheatresByCity(String city, String movie) {
        return theatreRepository.fetchTheatresByCity(city).stream()
                .filter(theatre -> theatre.getShows().stream()
                        .anyMatch(show -> movie.equals(show.getMovie().getMovieName())))
                .toList();
    }
}
