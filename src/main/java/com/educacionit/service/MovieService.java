package com.educacionit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.model.Genre;
import com.educacionit.model.Movie;
import com.educacionit.model.dto.MovieRequestDTO;
import com.educacionit.repository.GenreRepository;
import com.educacionit.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;

    public Movie searchById(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoringCase(title);
    }

    public List<Movie> searchByGenre(String genre) {
        return movieRepository.findByGenres_Name(genre);
    }

    public Movie getMovieDetails(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public Movie saveMovie(MovieRequestDTO movieRequestDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDTO.getTitle());
        movie.setWebsite(movieRequestDTO.getWebsite());
        movie.setImageurl(movieRequestDTO.getImageurl());
        List<String> genresNames = movieRequestDTO.getGenresNames();
        if (genresNames != null) {
            List<Genre> genres = genresNames.stream()
                    .map(genreName -> {
                        Genre genre = genreRepository.findByName(genreName);
                        if (genre == null) {
                            genre = new Genre();
                            genre.setName(genreName);
                            genre = genreRepository.save(genre);
                        }
                        return genre;
                    }).collect(Collectors.toList());

            movie.setGenres(genres);
        }

        return movieRepository.save(movie);
    }

    public Movie updateMovie(Integer id, MovieRequestDTO movieRequestDTO) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movie.get().setTitle(movieRequestDTO.getTitle());
            movie.get().setWebsite(movieRequestDTO.getWebsite());
            movie.get().setImageurl(movieRequestDTO.getImageurl());
            List<String> genresNames = movieRequestDTO.getGenresNames();
            if (genresNames != null) {
                List<Genre> genres = genresNames.stream()
                        .map(genreName -> {
                            Genre genre = genreRepository.findByName(genreName);
                            if (genre == null) {
                                genre = new Genre();
                                genre.setName(genreName);
                                genre = genreRepository.save(genre);
                            }
                            return genre;
                        }).collect(Collectors.toList());
                movie.get().setGenres(genres);
            }
            return movieRepository.save(movie.get());
        } else {
            return null;
        }
    }

    public void deleteMovie(Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
        }
        ///tirar excepcion
    }

}
