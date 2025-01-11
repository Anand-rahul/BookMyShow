package com.java.bms.Service;

import com.java.bms.Model.PriceCategory;
import com.java.bms.Model.Screen;
import com.java.bms.Model.Seat;
import com.java.bms.Model.Show;
import com.java.bms.Repository.ScreenRepository;
import com.java.bms.Repository.SeatRepository;
import com.java.bms.Repository.ShowRepository;
import com.java.bms.dto.ShowDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScreenRepository screenRepository;

//    public List<Seat> getAvailableSeats(int showId) {
//        Show show = showRepository.findById(showId)
//                .orElseThrow(() -> new RuntimeException("Show not found"));
//        List<Integer> bookedSeatIds = show.getBookedSeatIds();
//        return screenRepository.findByScreenAndSeatIdNotIn(show.getScreen().getScreenId(), bookedSeatIds);
//    }
    public List<Seat> getAvailableSeats(int showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with id: " + showId));
        // Convert booked seat IDs to Set for O(1) lookup
        Set<Integer> bookedSeatIds = new HashSet<>(show.getBookedSeatIds());

        Screen screen = show.getScreen();
        if (screen == null) {
            throw new RuntimeException("Screen not found for show: " + showId);
        }

        return screen.getSeats().stream()
                .filter(seat -> !bookedSeatIds.contains(seat.getId()))
                .collect(Collectors.toList());
    }

    public ShowDetails getShowDetails(int showId) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        Screen screen = screenRepository.findByScreenId(show.getScreen().getScreenId());
        List<Seat> allSeats = screen.getSeats();
        List<Integer> bookedSeatIds = show.getBookedSeatIds();
        log.info(allSeats.toString());
        List<PriceCategory> priceCategories = calculatePriceCategories(allSeats, bookedSeatIds);

        return new ShowDetails(allSeats, priceCategories);
    }


    private List<PriceCategory> calculatePriceCategories(List<Seat> allSeats, List<Integer> bookedSeatIds) {
        // Example implementation - This can be extended as per the business logic.
        Map<String, PriceCategory> categoryMap = new HashMap<>();
        for (Seat seat : allSeats) {
            String categoryName = seat.getPriceCategory();
            categoryMap.putIfAbsent(categoryName, new PriceCategory(categoryName, seat.getPrice(), "available"));

            if (bookedSeatIds.contains(seat.getId())) {
                categoryMap.get(categoryName).setStatus("filling");
            }
        }
        return new ArrayList<>(categoryMap.values());
    }
}
