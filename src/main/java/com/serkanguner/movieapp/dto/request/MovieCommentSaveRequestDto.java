package com.serkanguner.movieapp.dto.request;

import com.serkanguner.movieapp.entity.Movie;
import com.serkanguner.movieapp.entity.User;

public record MovieCommentSaveRequestDto(String content, Long user_id, Long movie_id) {
}
