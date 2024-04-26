package com.serkanguner.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private double rating;
    @Column(length = 2048)
    private String summary;
    private String premiered;
    private String url;

    @ManyToMany()
    private List<Genre> genres;

    @OneToMany(mappedBy ="movie")
    private List<MovieComment> comments;

    @ManyToMany(mappedBy = "favmovies")
    private List<User> users;
}
