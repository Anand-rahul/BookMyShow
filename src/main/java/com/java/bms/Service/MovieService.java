package com.java.bms.Service;

import com.java.bms.Enums.*;
import com.java.bms.Model.*;
import com.java.bms.Repository.LocationRepository;
import com.java.bms.Repository.MovieRepository;
import org.hibernate.metamodel.mapping.internal.MutableAttributeMappingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private LocationRepository locationRepository;

    public Movie saveMovie(Movie movie) {
        // Ensure locations exist before saving movie
        List<Location> validatedLocations = locationRepository.findAllById(
                movie.getLocationIds().stream().map(Location::getId).toList()
        );
        movie.setLocationIds(validatedLocations);
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie) {
        Movie currentMovie = movieRepository.findByMovieName(movie.getMovieName());
        if (currentMovie != null) {
            currentMovie.setMovieDurationInMinutes(movie.getMovieDurationInMinutes());
            currentMovie.setLocationIds(locationRepository.findAllById(
                    movie.getLocationIds().stream().map(Location::getId).toList()));
            return movieRepository.save(currentMovie);
        } else {
            return movieRepository.save(movie);
        }
    }

    public List<Movie> getMoviesByLocation(String city) {
        return movieRepository.findMoviesByCity(city);
    }

    public Movie getMovieById(Integer movieId){
        return movieRepository.findMovieById(movieId);
    }

    public Page<Movie> getAllMoviesPaginated(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
}