package com.serkanguner.movieapp.mapper;


import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.entity.Movie;
import com.serkanguner.movieapp.entity.MovieComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieFindAllResponseDto movieFindAllResponseDto(Movie movie);
    Movie dtoToMovie(MovieSaveRequestDto dto);
}
