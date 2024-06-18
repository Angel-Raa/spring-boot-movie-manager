package com.github.angel.controller;

import com.github.angel.persistence.entity.Movie;
import com.github.angel.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{title}")
    public ResponseEntity<List<Movie>> getAllByTitle(@PathVariable String title){
        return ResponseEntity.ok(movieService.getAllByTitle(title));
    }


}
