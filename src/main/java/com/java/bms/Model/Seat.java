package com.java.bms.Model;

import com.java.bms.Enums.SeatCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int row;
    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;
    private String priceCategory;
    private String seatNumber;
    private double price;
    private boolean booked;


}
