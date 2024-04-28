package com.serkanguner.movieapp.controller;
import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserFavMovies;
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

    @GetMapping("/ratingfindall")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllResponseDto>> findAllByRatingGreaterThan(Double rating){
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rating));
    }

    @GetMapping("/premeriredBeforeDate")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllResponseDto>> findAllByPremieredBefore(String date){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }

    @GetMapping("checkratingscore")
    @CrossOrigin("*")
    public ResponseEntity<Object[]> checkRatingScore(Double rating){
        return ResponseEntity.ok(movieService.checkRatingScore(rating));
    }
    @GetMapping("/findbyratingafter")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllResponseDto>> findByRatingAfter(Double rating){
        return ResponseEntity.ok(movieService.findByRatingAfter(rating));
    }

    @GetMapping("/findAllByNameArray")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllResponseDto>> findAllByNameContainingIgnoreCase(String name, String name2){
        return ResponseEntity.ok(movieService.findAllByNameContainingIgnoreCase(name, name2));
    }

    @GetMapping("checkCountryScore")
    @CrossOrigin("*")
    public ResponseEntity<List<Object[]>> checkCountryScore(){
        return ResponseEntity.ok(movieService.checkCountryScore());
    }




}
