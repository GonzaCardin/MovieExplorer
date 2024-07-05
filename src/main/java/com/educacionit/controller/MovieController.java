package com.educacionit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.model.Movie;
import com.educacionit.model.dto.MovieRequestDTO;
import com.educacionit.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search/title")
    public List<Movie> searchByTitle(@RequestParam String title) {
        return movieService.searchByTitle(title);
    }

    @GetMapping("/search/genre")
    public List<Movie> searchByGenre(@RequestParam String genre) {
        return movieService.searchByGenre(genre);
    }

    @GetMapping("/details/{id}")
    public Movie showMovieDetails(@PathVariable Integer id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        Movie savedMovie = movieService.saveMovie(movieRequestDTO);
        if (savedMovie != null) {
            return ResponseEntity.ok(savedMovie);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody MovieRequestDTO movieRequestDTO) {
        Movie updatedMovie = movieService.updateMovie(id, movieRequestDTO);
        if (updatedMovie != null) {
            return ResponseEntity.ok(updatedMovie);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
