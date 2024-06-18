package com.github.angel.persistence.entity;

import com.github.angel.utils.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString(exclude = {"ratings"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(name = "release_year")
    private int releaseYear;
    @OneToMany(targetEntity = Rating.class, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "movie")
    private List<Rating> ratings;
}
