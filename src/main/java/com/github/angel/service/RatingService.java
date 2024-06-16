package com.github.angel.service;

import com.github.angel.persistence.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAll();
    List<Rating> getAllByMovie(Long movieId);
    List<Rating>  getAllByUserId(String username);
    Rating getById(Long id);
    void save(Rating rating);
    void update(Rating rating, Long id);
    void delete(Long id);

}
