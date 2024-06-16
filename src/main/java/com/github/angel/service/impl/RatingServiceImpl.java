package com.github.angel.service.impl;

import com.github.angel.exception.GlobalDefaultException;
import com.github.angel.persistence.entity.Rating;
import com.github.angel.persistence.repository.RatingRepository;
import com.github.angel.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository repository;
    @Override
    public List<Rating> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Rating> getAllByMovie(Long movieId) {
        return this.repository.findByMovieId(movieId);
    }

    @Override
    public List<Rating> getAllByUserId(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public Rating getById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new GlobalDefaultException("Not Found"));
    }

    @Override
    public void save(Rating rating) {
        this.repository.save(rating);
    }

    @Override
    public void update(Rating rating, Long id) {
        Rating update = this.getById(id);
        update.setRating(rating.getRating());
        update.setUserId(rating.getUserId());
        update.setMovieId(rating.getMovieId());
        this.repository.save(rating);
    }

    @Override
    public void delete(Long id) {
        Rating delete = this.getById(id);
        this.repository.delete(delete);

    }
}
