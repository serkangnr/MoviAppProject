package com.serkanguner.movieapp.util.Data;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.google.gson.Gson;
import com.serkanguner.movieapp.entity.Genre;
import com.serkanguner.movieapp.entity.Movie;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import com.serkanguner.movieapp.service.GenreService;
import com.serkanguner.movieapp.service.MovieService;
import com.serkanguner.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {
    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;

    public void saveMoviesFromTvMaze() {
        try {
            URL url = new URL("https://api.tvmaze.com/shows");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String jsonIcerik = "";
            jsonIcerik = reader.readLine(); //value içinde tüm json dosyası var.

            Root[] movieArray = new Gson().fromJson(jsonIcerik, Root[].class);
//            Arrays.stream(movieArray).forEach(System.out::println);


            Arrays.stream(movieArray).forEach(root -> {
                Long id = (long) root.id;
                String name = root.name;
                String language = root.language;
                String image = root.image.original;
                String premired = root.premiered;
                String summary = root.summary;
                String url1 = root.url;
                double rating = root.rating.average;
                String country = null;
                if (root.network != null) {
                    country = root.network.country.name;
                }

                ArrayList<String> genres = root.genres;


                Movie movie = Movie.builder()
                        .id(id)
                        .language(language)
                        .image(image)
                        .name(name)
                        .country(country)
                        .rating(rating)
                        .summary(summary)
                        .premiered(premired)
                        .url(url1)
                        .genres(genreService.genreSave(genres))

                .build();

//
//                Movie movie = new Movie();
//                movie.setName(name);
//                movie.setLanguage(language);
//                movie.setImage(image);
//                movie.setPremired(premired);
//                movie.setSummary(summary);
//                movie.setUrl(url1);
//                movie.setRating(rating);
//                movie.setCountry(country);
//                movie.setGenre(genreList);


                movieService.save(movie);


            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers(){
//        User user1=User.builder()
//                .name("Berkay")
//                .surname("Güzel")
//                .email("güzel@gmail.com")
//                .phone("5554443322")
//                .password("123")
//                .favgenres(genreService.genreSave(List.of("Drama","Horror","AŞKKKK")))
//                .favmovies(movieService.findAllById(List.of(1L,15L,20L)))
//                .build();
//
//        user1.setComments(List.of(
//                MovieComment.builder().content("Çok iyi bir filmdi").movie(movieService.findById(1L).get()).user(user1).build(),
//                MovieComment.builder().content("İzlediğin en harika  filmdi").movie(movieService.findById(15L).get()).user(user1).build(),
//                MovieComment.builder().content("Sonunu göremeden uyudum...").movie(movieService.findById(20L).get()).user(user1).build()
//        ));
//        userService.save(user1);
//
//        User user2=User.builder()
//                .name("Aslı")
//                .surname("Mert")
//                .email("asli@gmail.com")
//                .phone("5554443322")
//                .password("123")
//                .favgenres(genreService.genreSave(List.of("Action","Adventure")))
//                .favmovies(movieService.findAllById(List.of(2L,16L,21L)))
//                .build();
//
//        user2.setComments(List.of(
//                MovieComment.builder().content("Çok iyi bir filmdi").movie(movieService.findById(2L).get()).user(user2).build(),
//                MovieComment.builder().content("İzlediğin en harika  filmdi").movie(movieService.findById(16L).get()).user(user2).build(),
//                MovieComment.builder().content("Sonunu göremeden uyudum...").movie(movieService.findById(21L).get()).user(user2).build()
//        ));
//        userService.save(user2);
//
//        User user3=User.builder()
//                .name("Kenan")
//                .surname("Öktener")
//                .email("kenan@gmail.com")
//                .phone("5554443322")
//                .password("123")
//                .favgenres(genreService.genreSave(List.of("Mystery","Legal")))
//                .favmovies(movieService.findAllById(List.of(3L,17L,22L)))
//                .build();
//
//        user3.setComments(List.of(
//                MovieComment.builder().content("Çok iyi bir filmdi").movie(movieService.findById(3L).get()).user(user3).build(),
//                MovieComment.builder().content("İzlediğin en harika  filmdi").movie(movieService.findById(17L).get()).user(user3).build(),
//                MovieComment.builder().content("Sonunu göremeden uyudum...").movie(movieService.findById(22L).get()).user(user3).build()
//        ));
//        userService.save(user3);
//
//        User user4=User.builder()
//                .name("Salih")
//                .surname("Er")
//                .email("salih@gmail.com")
//                .phone("5554443322")
//                .password("123")
//                .favgenres(genreService.genreSave(List.of("Science-Fiction","War")))
//                .favmovies(movieService.findAllById(List.of(5L)))
//                .build();
//
//        user4.setComments(List.of(
//                MovieComment.builder().content("Çok iyi bir filmdi").movie(movieService.findById(5L).get()).user(user4).build(),
//                MovieComment.builder().content("İzlediğin en harika  filmdi").movie(movieService.findById(22L).get()).user(user4).build(),
//                MovieComment.builder().content("Sonunu göremeden uyudum...").movie(movieService.findById(17L).get()).user(user4).build()
//        ));
//        userService.save(user4);

        User user5=User.builder()
                .name("Serkan")
                .surname("Guner")
                .email("serkan@gmail.com")
                .phone("5455012677")
                .password("123")
                .favgenres(genreService.genreSave(List.of("Comedy","Action","Anime")))
                .favmovies(movieService.findAllById(List.of(40L,50L,26L)))
                .build();

        user5.setComments(List.of(
                MovieComment.builder().content("Çok iyi bir filmdi").movie(movieService.findById(40L).get()).user(user5).build(),
                MovieComment.builder().content("İzlediğin en harika  filmdi").movie(movieService.findById(50L).get()).user(user5).build(),
                MovieComment.builder().content("Sonunu göremeden uyudum...").movie(movieService.findById(100L).get()).user(user5).build()
        ));
        userService.save(user5);



    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        //saveMoviesFromTvMaze();
        //saveUsers();
    }
}
