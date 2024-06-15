package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.Rating;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<@Valid Rating, @Min(1) Long> {
    List<Rating> findByMovieId(@Min(1) Long movieId);
    @Query("SELECT r FROM Rating r JOIN r.user u WHERE u.username = :username")
    List<Rating> findByUsername(@NotNull @Param("username") String  username);


}
