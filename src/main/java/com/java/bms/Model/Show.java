package com.java.bms.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;

    private int showStartTime;

    @ElementCollection
    private List<Integer> bookedSeatIds = new ArrayList<>();

    // Getters and Setters

    public Show(){

    }

    public Show(int showId, Movie movie, Screen screen, int showStartTime, List<Integer> bookedSeatIds) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.bookedSeatIds = bookedSeatIds;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", screen=" + screen +
                ", showStartTime=" + showStartTime +
                ", bookedSeatIds=" + bookedSeatIds +
                '}';
    }
}