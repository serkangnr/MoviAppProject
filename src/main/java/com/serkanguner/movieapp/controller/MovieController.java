package com.serkanguner.movieapp.controller;
import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserFindAllResponseDto;
import com.serkanguner.movieapp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ROOT + MOVIE)
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody MovieSaveRequestDto dto){
        movieService.movieSaveDto(dto);
        return ResponseEntity.ok("Kayit Basarili");
    }
    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(movieService.findMovieDto());
    }

}
