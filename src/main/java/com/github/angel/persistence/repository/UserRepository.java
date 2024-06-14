package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<@Valid User, @Min(1) Long> {
}
