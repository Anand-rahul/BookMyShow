package com.java.bms.Repository;

import com.java.bms.Model.Screen;
import com.java.bms.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    @Query("SELECT s from Screen s where s.screenId = :screenId")
    Screen findByScreenId(@Param("screenId") int screenId);
}

