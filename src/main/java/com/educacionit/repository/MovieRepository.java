package com.educacionit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitleContainingIgnoringCase(String title);
    List<Movie> findByGenres_Name(String genreName);
}
