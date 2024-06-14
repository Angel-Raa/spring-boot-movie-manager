package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.Rating;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<@Valid Rating, @Min(1) Long> {
}
