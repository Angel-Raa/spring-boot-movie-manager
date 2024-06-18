package com.github.angel.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@ToString(exclude = {"ratings"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = @UniqueConstraint(
        columnNames = {"username"}
))
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Rating> ratings;

}
