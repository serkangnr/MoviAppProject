package com.serkanguner.movieapp.controller;
import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
