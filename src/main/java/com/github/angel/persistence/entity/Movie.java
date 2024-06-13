package com.github.angel.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "director"})
})
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String director;
    private String genre;
    @Column(name = "release_year")
    private int releaseYear;
    @OneToMany(targetEntity = Rating.class, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "movie")
    private List<Rating> ratings;
}