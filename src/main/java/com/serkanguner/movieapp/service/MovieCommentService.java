package com.serkanguner.movieapp.service;

import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.mapper.MovieCommentMapper;
import com.serkanguner.movieapp.repository.MovieCommentRepository;
import com.serkanguner.movieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // bir filme ait yorumlari listeleyen metot yaziniz
    public List<MovieCommentFindAllResponseDto> findAllByMovieId(Long movieId) {
        List<MovieComment> allByMovieId = movieCommentRepository.findAllByMovieId(movieId);
        return allByMovieId.stream().map(MovieCommentMapper.INSTANCE::movieCommentFindAllResponseDto).collect(Collectors.toList());
    }

    public List<MovieCommentFindAllResponseDto> findAllContentByDateBetween(LocalDate start, LocalDate end){
        List<MovieComment> allByDateBetween = movieCommentRepository.findAllContentByDateBetween(start, end);
        return allByDateBetween.stream().map(MovieCommentMapper.INSTANCE::movieCommentFindAllResponseDto).collect(Collectors.toList());
    }

//    public List<MovieCommentFindAllResponseDto> findAllByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end){
//        List<MovieComment> allByUserIdAndDateBetween = movieCommentRepository.findAllByUserIdAndDateBetween(userId, start, end);
//        return allByUserIdAndDateBetween.stream().map(MovieCommentMapper.INSTANCE::movieCommentFindAllResponseDto).collect(Collectors.toList());
//    }


    public List<MovieCommentFindAllResponseDto>findAllComentByDateBetweenById(LocalDate start, LocalDate end, Long id){
        List<MovieCommentFindAllResponseDto>movieCommentFindAllResponseDtos=new ArrayList<>();
        movieCommentRepository.findAllByUserIdAndDateBetween(id,start,end).forEach(movieComment -> {
            if(movieComment.getUser().getId()==id){
                movieCommentFindAllResponseDtos.add(MovieCommentMapper.INSTANCE.movieCommentFindAllResponseDto(movieComment));
            }
        });
        return movieCommentFindAllResponseDtos;
    }

    public List<MovieCommentFindAllResponseDto> findAllByContentContainingIgnoreCase(String content){
        List<MovieComment> allByContentContainingIgnoreCase = movieCommentRepository.findAllByContentContainingIgnoreCase(content);
        return allByContentContainingIgnoreCase.stream().map(MovieCommentMapper.INSTANCE::movieCommentFindAllResponseDto).collect(Collectors.toList());
    }

    public List<MovieCommentFindAllResponseDto> findAllByContentLengthGreaterThan(int length){
        List<MovieComment> allByContentLengthGreaterThan = movieCommentRepository.findAllByContentGreaterThan(length);
        return allByContentLengthGreaterThan.stream().map(MovieCommentMapper.INSTANCE::movieCommentFindAllResponseDto).collect(Collectors.toList());
    }











}
