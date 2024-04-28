package com.serkanguner.movieapp.service;

import com.serkanguner.movieapp.dto.request.GenreSaveRequestDto;
import com.serkanguner.movieapp.dto.response.GenreFindAllResponseDto;
import com.serkanguner.movieapp.entity.Genre;
import com.serkanguner.movieapp.mapper.GenreMapper;
import com.serkanguner.movieapp.repository.GenreRepository;
import com.serkanguner.movieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService extends ServiceManager<Genre, Long> {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }

    public void genreSaveDto(GenreSaveRequestDto dto) {
        genreRepository.save(GenreMapper.INSTANCE.dtoToGenre(dto));
    }

    public List<GenreFindAllResponseDto> findGenreDto() {
        List<GenreFindAllResponseDto> genreFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(user -> {
            genreFindAllResponseDtos.add(GenreMapper.INSTANCE.GenreToUserFindAllResponseDto(user));
        });
        return genreFindAllResponseDtos;
    }

    public List<Genre> genreSave(List<String> genres) {
        List<Genre> genreList = new ArrayList<>();
        for (String genreName : genres) {
            Optional<Genre> optionalGenre = genreRepository.findByName(genreName);
            //Eger optionalGenre dolu ise, yani daha once database'de var ise ne yapmaliyiz?
            if (optionalGenre.isPresent()) {
                genreList.add(optionalGenre.get());
            } else {
                Genre yeniGelenGenre = Genre.builder().name(genreName).build();
                genreRepository.save(yeniGelenGenre);
                genreList.add(yeniGelenGenre);
            }
        }
        return genreList;

    }


}