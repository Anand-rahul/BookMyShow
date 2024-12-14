package com.java.bms.Repository;

import com.java.bms.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /*@Query("Select * from Movie where city=@Param")
    List<Movie> findMoviesByCity(String city);*/

    Movie findByMovieName(String Name);

    @Query("SELECT m FROM Movie m JOIN m.locationIds l WHERE l.city = :city")
    List<Movie> findMoviesByCity(@Param("city") String city);
}