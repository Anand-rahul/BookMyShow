package com.java.bms.Repository;

import com.java.bms.Model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query("Select  t FROM Theatre t where t.city=:city")
    List<Theatre> fetchTheatresByCity(String city);
}
