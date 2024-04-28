package com.serkanguner.movieapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    @Email(message = "Mail adresiniz yalnizca gmail adresi olmali!!")
    private String email;
    @Column(length = 11)
    @Size(min = 11, max = 11 , message = " Telefon numaraniz 11 haneli olmalidir." )
    @Pattern(regexp = "\\d+", message = " Telefon numaraniz yalnizca rakamlardan olusmalidir.")
    private String phone;
    @Column(length = 50)
    private String password;

    @ManyToMany
    private List<Movie> favmovies;

    @ManyToMany
    private List<Genre> favgenres;
    // User one traf oldugu icin Karsi taraftir. Bu tarafta mappedBy kullanilir.
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    private List<MovieComment> comments;
}
