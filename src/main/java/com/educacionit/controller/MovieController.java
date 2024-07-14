package com.educacionit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educacionit.model.Movie;
import com.educacionit.model.dto.MovieRequestDTO;
import com.educacionit.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search/title")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Movie> searchByTitle(@RequestParam String title) {
        return movieService.searchByTitle(title);
    }

    @GetMapping("/search/genre")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Movie> searchByGenre(@RequestParam String genre) {
        return movieService.searchByGenre(genre);
    }

    @GetMapping("/details/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Movie showMovieDetails(@PathVariable Integer id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        try {
            Movie savedMovie = movieService.saveMovie(movieRequestDTO);
            return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody MovieRequestDTO movieRequestDTO) {
        try {
            Movie updatedMovie = movieService.updateMovie(id, movieRequestDTO);
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
