package com.java.bms.Service;

import com.java.bms.Model.Theatre;
import com.java.bms.Repository.TheatreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

@Service
@Slf4j
@Transactional
public class TheatreService {

    private final TheatreRepository theatreRepository;
    private final ExecutorService asyncExecutorService;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository, ExecutorService asyncExecutorService) {
        this.theatreRepository = theatreRepository;
        this.asyncExecutorService = asyncExecutorService;
    }

    /**
     * Fetch all theatres asynchronously.
     */
    public CompletableFuture<List<Theatre>> getAllTheatres() {
        return CompletableFuture.supplyAsync(theatreRepository::findAll, asyncExecutorService)
                .thenApply(theatres -> {
                    log.info("Successfully fetched {} theatres", theatres.size());
                    return theatres;
                })
                .exceptionally(ex -> {
                    log.error("Error fetching all theatres: ", ex);
                    return Collections.emptyList();
                });
    }

    /**
     * Save a new theatre asynchronously.
     */
    public CompletableFuture<Theatre> saveTheatre(Theatre theatre) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Saving new theatre: {}", theatre.getTheatreId());
                    return theatreRepository.save(theatre);
                }, asyncExecutorService)
                .thenApply(savedTheatre -> {
                    log.info("Successfully saved theatre: {}", savedTheatre.getTheatreId());
                    return savedTheatre;
                })
                .exceptionally(ex -> {
                    log.error("Error saving theatre: ", ex);
                    throw new CompletionException("Failed to save theatre", ex);
                });
    }

    /**
     * Fetch theatres by city and movie asynchronously.
     */
    public CompletableFuture<List<Theatre>> fetchTheatresByCity(String city, String movie) {
        log.info("Fetching theatres for city: {} and movie: {}", city, movie);

        return CompletableFuture.supplyAsync(() -> {
                    try {
                        List<Theatre> theatres = theatreRepository.fetchTheatresByCity(city);
                        log.debug("Found {} theatres in city: {}", theatres.size(), city);

                        List<Theatre> filteredTheatres = theatres.stream()
                                .filter(theatre -> theatre.getShows().stream()
                                        .anyMatch(show -> movie.equals(show.getMovie().getMovieName())))
                                .toList();

                        log.info("Successfully filtered theatres. Found {} theatres showing movie: {}",
                                filteredTheatres.size(), movie);
                        return filteredTheatres;

                    } catch (Exception e) {
                        log.error("Error while fetching theatres for city: {} and movie: {}", city, movie, e);
                        throw e;
                    }
                }, asyncExecutorService)
                .exceptionally(ex -> {
                    log.error("Failed to complete theatre fetch operation for city: {} and movie: {}",
                            city, movie, ex);
                    return Collections.emptyList();
                });
    }

    /**
     * Fetch a theatre by its ID asynchronously.
     */
    public CompletableFuture<Optional<Theatre>> fetchTheatreById(int theatreId) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Fetching theatre by ID: {} in thread: {}", theatreId, Thread.currentThread().getName());
                    return theatreRepository.findById(theatreId);
                }, asyncExecutorService)
                .thenApply(optionalTheatre -> {
                    if (optionalTheatre.isPresent()) {
                        log.info("Successfully fetched theatre with ID: {}", theatreId);
                    } else {
                        log.warn("Theatre with ID: {} not found", theatreId);
                    }
                    return optionalTheatre;
                })
                .exceptionally(ex -> {
                    log.error("Error fetching theatre by ID: {}", theatreId, ex);
                    return Optional.empty();
                });
    }
}
