package com.java.bms.Controller;

import com.java.bms.Model.Theatre;
import com.java.bms.Service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatres")
@Tag(name = "Theatre Management")
@Validated
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @Operation(summary = "Get all theatres")
    @GetMapping("/all")
    public ResponseEntity<List<Theatre>> getAllTheatres() {
        return ResponseEntity.ok(theatreService.getAllTheatres());
    }

    @Operation(summary = "Add new theatre")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Theatre> addTheatre(@Valid @RequestBody Theatre theatre) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(theatreService.saveTheatre(theatre));
    }


    @Operation(summary = "Get theatres by city and movie")
    @GetMapping("/fetch-by-city")
    public ResponseEntity<List<Theatre>> getTheatresByCity(
            @RequestParam @NotBlank String city,
            @RequestParam @NotBlank String movie) {
        return ResponseEntity.ok(theatreService.fetchTheatresByCity(city, movie));
    }
    @Operation(summary = "Get theatre by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Theatre> getTheatreDetails(@PathVariable @Positive int id) throws Exception {
        return theatreService.fetchTheatreById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new Exception("Theatre not found with id: " + id));
    }
}