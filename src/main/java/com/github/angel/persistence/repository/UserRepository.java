package com.github.angel.persistence.repository;

import com.github.angel.persistence.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<@Valid User, @Min(1) Long> {
    List<User> findByNameContaining(@NotNull String name);
    Optional<User> findByUsername(@NotNull String username);
    @Modifying
    void deleteByUsername(@NotNull String username);

}
