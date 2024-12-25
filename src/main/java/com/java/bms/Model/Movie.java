package com.java.bms.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

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
    public String posterUrl;
    public double rating;
    public String votes;
    public String genre;
    public List<String>genres;
    public String description;
    public List<String> casts;

    public Movie(int movieId, String movieName, int movieDurationInMinutes, List<Location> locationIds, String posterUrl, double rating, String votes, String genre, List<String> genres, String description, List<String> cast) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDurationInMinutes = movieDurationInMinutes;
        this.locationIds = locationIds;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.votes = votes;
        this.genre = genre;
        this.genres = genres;
        this.description = description;
        this.casts = cast;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCasts() {
        return casts;
    }

    public void setCasts(List<String> casts) {
        this.casts = casts;
    }

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


    public Movie() {
    }


}