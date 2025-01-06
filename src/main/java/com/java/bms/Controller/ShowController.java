package com.java.bms.Controller;

import com.java.bms.Model.Seat;
import com.java.bms.Model.Show;
import com.java.bms.Service.ShowService;
import com.java.bms.dto.ShowDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@Tag(name = "Show Management")
@Validated
public class ShowController {

    @Autowired
    private ShowService showService;

    @Operation(summary = "Get available seats for a show")
    @GetMapping("/seats/{showId}")
    public ResponseEntity<List<Seat>> getAvailableSeats(
            @PathVariable @Positive int showId) {
        return ResponseEntity.ok(showService.getAvailableSeats(showId));
    }

    @Operation(summary = "Get show details")
    @GetMapping("/{showId}/details")
    public ResponseEntity<ShowDetails> getShowDetails(
            @PathVariable @Positive int showId) {
        return ResponseEntity.ok(showService.getShowDetails(showId));
    }

}