package com.java.bms.dto;

import com.java.bms.Model.PriceCategory;
import com.java.bms.Model.Seat;

import java.util.List;

public class ShowDetails {

    private List<Seat> seats;
    private List<PriceCategory> priceCategories;

    public ShowDetails(List<Seat> seats, List<PriceCategory> priceCategories) {
        this.seats = seats;
        this.priceCategories = priceCategories;
    }

    // Getters and setters

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<PriceCategory> getPriceCategories() {
        return priceCategories;
    }

    public void setPriceCategories(List<PriceCategory> priceCategories) {
        this.priceCategories = priceCategories;
    }
}
