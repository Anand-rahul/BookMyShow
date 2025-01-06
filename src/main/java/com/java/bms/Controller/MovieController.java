package com.java.bms.Controller;

import com.java.bms.Model.Movie;
import com.java.bms.Service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movie Management")
@Validated
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Operation(summary = "Create movie")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movieService.saveMovie(movie));
    }



    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping
    @Operation(summary = "Get all movies with pagination")
    public ResponseEntity<Page<Movie>> getAllMoviesPaginated(
            @Parameter(description = "Page number")
            @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Items per page")
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(movieService.getAllMoviesPaginated(PageRequest.of(page, size)));
    }

    @PutMapping("/update")
    @Operation(summary = "Update movie")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    @Operation(summary = "Get movies by city")
    @GetMapping("/{city}")
    public ResponseEntity<List<Movie>> getMoviesByLocation(@PathVariable String city) {
        return ResponseEntity.ok(movieService.getMoviesByLocation(city));
    }


    @Operation(summary = "Get movie by ID")
    @GetMapping("/id/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
}