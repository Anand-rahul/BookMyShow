package com.java.bms.Controller;

import com.java.bms.Model.Seat;
import com.java.bms.Model.Show;
import com.java.bms.Service.ShowService;
import com.java.bms.dto.ShowDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/seats/{showId}")
    public List<Seat> getAvailableSeats(@PathVariable int showId) {
        return showService.getAvailableSeats(showId);
    }

    @GetMapping("/{showId}/details")
    public ShowDetails getShowDetails(@PathVariable int showId) {
        return showService.getShowDetails(showId);
    }

}