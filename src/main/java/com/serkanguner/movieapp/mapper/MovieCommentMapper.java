package com.serkanguner.movieapp.mapper;



import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieCommentMapper {
    MovieCommentMapper INSTANCE = Mappers.getMapper(MovieCommentMapper.class);

    MovieCommentFindAllResponseDto movieCommentFindAllResponseDto(MovieComment movieComment);
    MovieComment dtoToMovieComment(MovieCommentSaveRequestDto dto);
}
