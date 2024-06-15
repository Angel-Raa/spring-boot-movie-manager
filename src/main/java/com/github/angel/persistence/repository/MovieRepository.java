package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.Movie;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<@Valid Movie, @Min(1) Long> {
    List<Movie> findByTitleContaining(@NotNull String title);
    List<Movie> findByGenre(@NotNull Movie genre);
    List<Movie> findByGenreAndTitleContaining(@NotNull Movie genre, @NotNull String title);
}