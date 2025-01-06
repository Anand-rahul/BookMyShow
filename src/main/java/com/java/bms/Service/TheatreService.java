package com.java.bms.Service;

import com.java.bms.Model.Theatre;
import com.java.bms.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Theatre> fetchTheatreById(int theatreId){
        return theatreRepository.findById(theatreId);
    }
}
