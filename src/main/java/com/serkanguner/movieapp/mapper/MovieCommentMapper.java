package com.serkanguner.movieapp.mapper;



import com.serkanguner.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.serkanguner.movieapp.dto.response.MovieCommentFindAllResponseDto;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieCommentMapper {
    MovieCommentMapper INSTANCE = Mappers.getMapper(MovieCommentMapper.class);

    @Mapping(target = "movie_id", source = "movieComment.movie.id")
    @Mapping(target = "user_id", source = "movieComment.user.id")

    MovieCommentFindAllResponseDto movieCommentFindAllResponseDto(MovieComment movieComment);
    MovieComment dtoToMovieComment(MovieCommentSaveRequestDto dto);
}
