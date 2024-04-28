package com.serkanguner.movieapp.dto.response;

import java.util.List;

public record UserCommentsDto(List<MovieCommentFindAllResponseDto> comments , String name, String surname) {
}
