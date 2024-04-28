package com.serkanguner.movieapp.repository;


import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {

    //Bir filme ait yorumlari listeleyen sorguyu yaziniz

    List<MovieComment> findAllByMovieId(Long movieId);

    List<MovieComment> findAllContentByDateBetween( LocalDate start, LocalDate end);

    List<MovieComment> findAllByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end);

    List<MovieComment> findAllByContentContainingIgnoreCase(String content);

    // Yorumun uzunlugu 20 karakterden buyuk olanlar

    @Query(value = "SELECT u FROM MovieComment u WHERE length(u.content)>:x ")
    List<MovieComment> findAllByContentGreaterThan(@Param("x") int length);








}
