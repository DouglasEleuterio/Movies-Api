package br.com.douglas.movies.controllers;

import br.com.douglas.movies.dtos.MessageDto;
import br.com.douglas.movies.dtos.MovieDto;
import br.com.douglas.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @Autowired
    MovieService service;

    @GetMapping("/totalMovies")
    public ResponseEntity<MessageDto> getTotalMovies() {
        MessageDto allMovies = service.getTotalMovies();
        return ResponseEntity.ok(allMovies);
    }

    @GetMapping("/totalMoviesByGenre")
    public ResponseEntity<MessageDto> getTotalMoviesByGenre() {
        MessageDto allMovies = service.getTotalMoviesByGenre();
        return ResponseEntity.ok(allMovies);
    }
}
