package com.java.bms.Controller;

import com.java.bms.ExceptionHandler.TheatreNotFoundException;
import com.java.bms.Model.Theatre;
import com.java.bms.Service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping("/theatres")
@Tag(name = "Theatre Management")
@Validated
@Slf4j
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private Executor asyncExecutor;

    @Operation(summary = "Get all theatres")
    @GetMapping("/all")
    public CompletableFuture<ResponseEntity<List<Theatre>>> getAllTheatres() {
        return theatreService.getAllTheatres()
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    log.error("Error fetching all theatres", ex);
                    return ResponseEntity
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .build();
                });
    }

    @Operation(summary = "Add new theatre")
    @PostMapping("/add")
    public CompletableFuture<ResponseEntity<Theatre>> addTheatre(
            @Valid @RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre)
                .thenApply(savedTheatre ->
                        ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(savedTheatre))
                .exceptionally(ex -> {
                    log.error("Error saving theatre", ex);
                    return ResponseEntity
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .build();
                });
    }

    @Operation(summary = "Get theatres by city and movie")
    @GetMapping("/fetch-by-city")
    public CompletableFuture<ResponseEntity<List<Theatre>>> getTheatresByCity(
            @RequestParam @NotBlank String city,
            @RequestParam @NotBlank String movie) {

        log.info("Request received to fetch theatres for city: {} and movie: {}", city, movie);

        return theatreService.fetchTheatresByCity(city, movie)
                .thenApply(theatres -> {
                    log.info("Successfully fetched {} theatres for city: {} and movie: {}",
                            theatres.size(), city, movie);
                    return ResponseEntity.ok(theatres);
                })
                .exceptionally(ex -> {
                    log.error("Error fetching theatres by city: {} and movie: {}. Exception: {}",
                            city, movie, ex.getMessage(), ex);
                    return ResponseEntity
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .build();
                });
    }

    @Operation(summary = "Get theatre by ID")
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Theatre>> getTheatreDetails(
            @PathVariable @Positive int id) {

        return theatreService.fetchTheatreById(id)
                .thenApply(optionalTheatre -> optionalTheatre
                        .map(theatre -> {
                            log.info("Successfully fetched theatre with ID: {}", id);
                            return ResponseEntity.ok(theatre);
                        })
                        .orElseGet(() -> {
                            log.warn("Theatre not found with ID: {}", id);
                            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                        }))
                .exceptionally(ex -> {
                    log.error("Error fetching theatre by ID: {}", id, ex);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }
}
