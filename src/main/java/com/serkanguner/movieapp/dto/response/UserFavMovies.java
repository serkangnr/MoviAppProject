package com.serkanguner.movieapp.dto.response;

import com.serkanguner.movieapp.entity.Movie;

import java.util.List;

public record UserFavMovies(List<MovieFindAllResponseDto> favmovies , String name ) {
}
