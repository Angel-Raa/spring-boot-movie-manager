package com.github.angel.controller;

import com.github.angel.persistence.entity.Movie;
import com.github.angel.service.MovieService;
import com.github.angel.utils.Genre;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/example")
    public ResponseEntity<String >example(){
        return new ResponseEntity<>("Hola Mundo", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie body,
                                      HttpServletRequest request){
        String base = request.getRequestURL().toString();
        Movie movieSave = movieService.save(body);
        URI uri = URI.create(base + "/"+  movieSave.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(uri)
                .body(movieSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update (@RequestBody Movie body, @PathVariable Long id){
        Movie movie = movieService.update(id, body);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id){
        Map<String, String> msg = Map.of("Message", "Movie successfully removed");
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(msg);
    }
}
