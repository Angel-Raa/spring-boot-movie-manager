package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.Movie;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<@Valid Movie, @Min(1) Long> {
}
