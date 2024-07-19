package com.educacionit.controller;

import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educacionit.model.Movie;
import com.educacionit.service.MovieService;

@Controller
public class HomeController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/movies")
    @ResponseBody
    public List<Movie> getMovies(@RequestParam(defaultValue = "1")int page){
        return movieService.getMovies(page);
    }

}
