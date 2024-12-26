package com.java.bms.Repository;

import com.java.bms.Model.Screen;
import com.java.bms.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {



}

