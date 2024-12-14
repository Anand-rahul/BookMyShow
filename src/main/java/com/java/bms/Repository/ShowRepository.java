package com.java.bms.Repository;

import com.java.bms.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Query("SELECT s FROM Show s JOIN s.movie m JOIN m.locationIds l WHERE m.movieId = :movieId AND l.city = :city")
    List<Show> findShowsByMovieIdAndCity(@Param("movieId") int movieId, @Param("city") String city);
}