package com.serkanguner.movieapp.dto.response;

import java.util.List;

public record MovieFindAllResponseDto(Long id, String name, String language, String image, String country, Double rating, String summary, String url,
                                      List<GenreFindAllResponseDto> genres) {
}
