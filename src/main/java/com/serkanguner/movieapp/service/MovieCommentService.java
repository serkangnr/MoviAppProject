package com.serkanguner.movieapp.service;

import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.mapper.MovieCommentMapper;
import com.serkanguner.movieapp.mapper.MovieMapper;
import com.serkanguner.movieapp.repository.MovieCommentRepository;
import com.serkanguner.movieapp.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieCommentService extends ServiceManager<MovieComment,Long> {
    private final MovieCommentRepository movieCommentRepository;


    public MovieCommentService(MovieCommentRepository movieCommentRepository) {
        super(movieCommentRepository);
        this.movieCommentRepository = movieCommentRepository;
    }

    public void movieSaveDTO(MovieCommentSaveRequestDto dto) {
        movieCommentRepository.save(MovieCommentMapper.INSTANCE.dtoToMovieComment(dto));
    }

    public List<MovieCommentFindAllResponseDto> findMovieCommentDto() {
        List<MovieCommentFindAllResponseDto> movieCommentFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(movieComment -> {
            movieCommentFindAllResponseDtos.add(MovieCommentMapper.INSTANCE.movieCommentFindAllResponseDto(movieComment));
        });
        return movieCommentFindAllResponseDtos;
    }


}
