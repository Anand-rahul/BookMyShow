package com.java.bms.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Nonnull
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    private int movieDurationInMinutes;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_location",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locationIds;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDurationInMinutes() {
        return movieDurationInMinutes;
    }

    public void setMovieDurationInMinutes(int movieDurationInMinutes) {
        this.movieDurationInMinutes = movieDurationInMinutes;
    }

    public List<Location> getLocationIds() {
        return locationIds;
    }

    public void setLocationIds(List<Location> locationIds) {
        this.locationIds = locationIds;
    }

    public Movie(int movieId, String movieName, int movieDurationInMinutes) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDurationInMinutes = movieDurationInMinutes;
    }

    public Movie() {
    }


}