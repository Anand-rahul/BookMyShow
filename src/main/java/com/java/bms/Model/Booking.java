package com.java.bms.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    private String status; // e.g., "PENDING", "CONFIRMED", "CANCELLED"

    @OneToMany
    private List<Seat> bookedSeats = new ArrayList<>();

    @OneToOne
    private Payment payment;

    // Getters and Setters
    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key column in Booking table
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Booking(Long id, Show show, List<Seat> bookedSeats, Payment payment) {
        this.id = id;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    public Booking() {
    }
}
