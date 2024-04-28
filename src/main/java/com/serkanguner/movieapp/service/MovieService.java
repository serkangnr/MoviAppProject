package com.serkanguner.movieapp.service;

import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.entity.Movie;
import com.serkanguner.movieapp.exception.ErrorType;
import com.serkanguner.movieapp.exception.MovieAppException;
import com.serkanguner.movieapp.mapper.MovieMapper;
import com.serkanguner.movieapp.repository.MovieRepository;
import com.serkanguner.movieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService extends ServiceManager<Movie,Long> {
  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    super(movieRepository);
    this.movieRepository = movieRepository;
  }

  public void movieSaveDto(MovieSaveRequestDto dto) {
    movieRepository.save(MovieMapper.INSTANCE.dtoToMovie(dto));
  }

  public List<MovieFindAllResponseDto> findMovieDto() {
    List<MovieFindAllResponseDto> movieFindAllResponseDtos = new ArrayList<>();

    findAll().forEach(movie -> {
      movieFindAllResponseDtos.add(MovieMapper.INSTANCE.movieFindAllResponseDto(movie));
    });
    return movieFindAllResponseDtos;
  }

   public List<Movie> findAllById(List<Long> ids){
    return ids.stream()
            .map(id -> findById(id).orElseThrow(()-> new MovieAppException(ErrorType.MOVIE_NOT_FOUND) ))
            .collect(Collectors.toList());
   }

   public List<MovieFindAllResponseDto> findAllByRatingGreaterThan(Double rating){
    return movieRepository.findAllByRatingGreaterThan(rating).stream()
           .map(MovieMapper.INSTANCE::movieFindAllResponseDto)
           .collect(Collectors.toList());
   }


}
