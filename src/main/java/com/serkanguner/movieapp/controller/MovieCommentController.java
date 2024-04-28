package com.serkanguner.movieapp.controller;
import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(ROOT + MOVIECOMMENT)
@RequiredArgsConstructor
public class MovieCommentController {
    private final MovieCommentService movieCommentService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody MovieCommentSaveRequestDto dto){
        movieCommentService.movieSaveDTO(dto);
        return ResponseEntity.ok("Kayit Basarili");
    }
    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(movieCommentService.findMovieCommentDto());
    }

    @GetMapping("/findAllByMovieId")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllByMovieId(Long movieId){
        return ResponseEntity.ok(movieCommentService.findAllByMovieId(movieId));
    }

    @GetMapping("/findBetweenDateStartAndEnd")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllContentByDateBetween(LocalDate start, LocalDate end){
        return ResponseEntity.ok(movieCommentService.findAllContentByDateBetween(start, end));
    }
    @GetMapping("/findBetweenDateStartAndEndById")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllComentByDateBetweenById(LocalDate start, LocalDate end, Long id){
        return ResponseEntity.ok(movieCommentService.findAllComentByDateBetweenById(start, end, id));
    }

    @GetMapping("/findByContentComments")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllByContentContainingIgnoreCase(String content){
        return ResponseEntity.ok(movieCommentService.findAllByContentContainingIgnoreCase(content));
    }

    @GetMapping("/findByChracterSize")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieCommentFindAllResponseDto>> findAllByContentLengthGreaterThan(int length) {
        return ResponseEntity.ok(movieCommentService.findAllByContentLengthGreaterThan(length));
    }





}
