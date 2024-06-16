package com.github.angel.service.impl;

import com.github.angel.exception.GlobalDefaultException;
import com.github.angel.persistence.entity.Movie;
import com.github.angel.persistence.repository.MovieRepository;
import com.github.angel.service.MovieService;
import com.github.angel.utils.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;

    @Override
    public List<Movie> getAllMovie() {
        return repository.findAll();
    }

    @Override
    public List<Movie> getAllByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    @Override
    public List<Movie> getAllByGenre(Genre genre) {
        return repository.findByGenreContaining(genre);
    }

    @Override
    public List<Movie> getAllByGenreAndTitle(Genre genre, String title) {
        return repository.findByGenreAndTitleContaining(genre, title);
    }

    @Override
    public Movie getById(Long id) {
        Movie movie = this.repository.findById(id).orElseThrow(( ) -> new GlobalDefaultException("Not found"));
        return movie;
    }

    @Override
    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie  update = getById(id);
        update.setDirector(movie.getDirector());
        update.setTitle(movie.getTitle());
        update.setReleaseYear(movie.getReleaseYear());
        update.setGenre(movie.getGenre());
        repository.save(update);
        return update;
    }

    @Override
    public void delete(Long id) {
        Movie movie = this.repository.findById(id).orElseThrow(( ) -> new GlobalDefaultException("Not found"));
        repository.delete(movie);
    }
}
