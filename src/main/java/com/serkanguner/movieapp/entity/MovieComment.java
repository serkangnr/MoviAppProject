package com.serkanguner.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_moviecomment")
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2048)
    private String content;
    @Builder.Default
    private LocalDate date=LocalDate.now();

    @ManyToOne
    private Movie movie;
    //Comment tarafi Many olan taraf oldugu icin ownerdir.
    @ManyToOne
    private User user;
}
