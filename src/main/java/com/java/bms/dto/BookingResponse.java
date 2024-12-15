package com.java.bms.dto;

import java.util.List;

public class BookingResponse {

    private Long bookingId;
    private String showName;
    private int showLocation;
    private String seatCategory;
    private List<Integer> bookedSeats;
    private String userMobile;
    private String bookingStatus;
    private String showTime;
    private int movieDuration;

    // Constructors
    public BookingResponse() {
    }

    public BookingResponse(Long bookingId, String showName, int showLocation, String seatCategory,
                           List<Integer> bookedSeats, String userMobile, String bookingStatus,
                           String showTime, int movieDuration) {
        this.bookingId = bookingId;
        this.showName = showName;
        this.showLocation = showLocation;
        this.seatCategory = seatCategory;
        this.bookedSeats = bookedSeats;
        this.userMobile = userMobile;
        this.bookingStatus = bookingStatus;
        this.showTime = showTime;
        this.movieDuration = movieDuration;
    }

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(int showLocation) {
        this.showLocation = showLocation;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }
}
