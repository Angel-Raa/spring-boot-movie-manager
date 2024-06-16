package com.github.angel.service;

import com.github.angel.persistence.entity.Movie;
import com.github.angel.utils.Genre;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovie();
    List<Movie> getAllByTitle(String title);
    List<Movie> getAllByGenre(Genre genre);
    List<Movie> getAllByGenreAndTitle(Genre genre, String title);
    Movie getById(Long id);
    Movie save(Movie movie);
    Movie update(Long id, Movie movie);
    void delete(Long id);

}
