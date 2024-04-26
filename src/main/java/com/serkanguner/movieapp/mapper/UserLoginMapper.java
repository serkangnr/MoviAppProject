package com.serkanguner.movieapp.mapper;

import com.serkanguner.movieapp.dto.request.UserLoginRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.dto.response.UserFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserLoginResponseDto;
import com.serkanguner.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserLoginMapper {
    UserLoginMapper INSTANCE = Mappers.getMapper(UserLoginMapper.class);
    UserLoginResponseDto userToUserLoginResponseDto(User user);
    User dtoToUser(UserLoginRequestDto dto);
}
