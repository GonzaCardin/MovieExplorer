package com.educacionit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String searchByTitle(@RequestParam String title, Model model) {
        List<Movie> movies = movieService.searchByTitle(title);
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/search/genre")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String searchByGenre(@RequestParam String genre, Model model) {
        List<Movie> movies = movieService.searchByGenre(genre);
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/details/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String showMovieDetails(@PathVariable Integer id, Model model) {
        Movie movie = movieService.getMovieDetails(id);
        model.addAttribute("movie", movie);
        return "movieDeatils";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        movieService.saveMovie(movieRequestDTO);
        return "redirect:/home";
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateMovie(@PathVariable Integer id, @RequestBody MovieRequestDTO movieRequestDTO) {
        movieService.updateMovie(id, movieRequestDTO);
        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return "redirect:/home";
    }
}
