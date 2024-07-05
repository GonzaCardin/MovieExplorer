package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByName(String name);
}
