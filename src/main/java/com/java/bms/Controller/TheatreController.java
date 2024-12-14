package com.java.bms.Controller;

import com.java.bms.Model.Theatre;
import com.java.bms.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping("/all")
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PostMapping("/add")
    public Theatre addTheatre(@RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre);
    }
}