package com.serkanguner.movieapp.repository;


import com.serkanguner.movieapp.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByRatingGreaterThan(Double rate);

    List<Movie> findAllByPremieredBefore(String date);

    List<Movie> findAllByPremieredAfter(String date);

    @Query(value = "SELECT m.rating, count(m.rating) AS count FROM Movie m group by  m.rating HAVING m.rating =:x")
    Object[] checkRatingScore(@Param("x") double rating);

    //belirli bir rating e sahip kac film vardir

    List<Movie> findByRatingAfter(Double rating);

    // [film1, film2] ismine sahip filmleri listeleyiniz

    List<Movie> findAllByNameOrName(@Param("name") String name, @Param("name2") String name2);

    //Her ulkede kac film vardir(Query)
    @Query(value = "SELECT m.country, count(m.country) AS count FROM Movie m group by  m.country ")
    List<Object[]> checkCountryScore();


//    @Query(value = "SELECT c.content FROM MovieComment c WHERE c.movie.id =:x")
//    List<String> checkComments(@Param("x") Long id);





}
