package com.java.bms.Controller;

import com.java.bms.Model.Show;
import com.java.bms.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/by-movie-and-city")
    public List<Show> getShowsByMovieIdAndCity(@RequestParam int movieId, @RequestParam String city) {
        return showService.getShowsByMovieIdAndCity(movieId, city);
    }
}