package com.serkanguner.movieapp.controller;

import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.GenreSaveRequestDto;
import com.serkanguner.movieapp.dto.request.MovieSaveRequestDto;
import com.serkanguner.movieapp.dto.response.GenreFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.MovieFindAllResponseDto;
import com.serkanguner.movieapp.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ROOT + GENRE)
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody GenreSaveRequestDto dto){
        genreService.genreSaveDto(dto);
        return ResponseEntity.ok("Kayit Basarili");
    }
    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<GenreFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(genreService.findGenreDto());
    }
}
