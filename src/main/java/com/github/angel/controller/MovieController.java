package com.github.angel.controller;

import com.github.angel.persistence.entity.Movie;
import com.github.angel.service.MovieService;
import com.github.angel.utils.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getByIdMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getAllByTitle(@PathVariable String title){
        return ResponseEntity.ok(movieService.getAllByTitle(title));
    }

    @GetMapping(value = "/filter", params = {"title", "genre"})
    public ResponseEntity<List<Movie>> getByTitleAndGenre(@RequestParam(name = "title") String title, @RequestParam(name = "genre") Genre genre) {
        return ResponseEntity.ok(movieService.getAllByGenreAndTitle(genre, title));
    }

}
