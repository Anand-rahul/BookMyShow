package com.java.bms.Service;

import com.java.bms.Model.Show;
import com.java.bms.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShowsByMovieIdAndCity(int movieId, String city) {
        return showRepository.findShowsByMovieIdAndCity(movieId, city);
    }
}

