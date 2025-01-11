package com.java.bms.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;

    @ManyToMany
    private List<Seat> seats = new ArrayList<>();


    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }
    public Screen(){

    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId=" + screenId +
                ", seats=" + seats +
                '}';
    }
}