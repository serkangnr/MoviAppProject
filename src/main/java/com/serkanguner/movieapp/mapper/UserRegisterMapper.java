package com.serkanguner.movieapp.mapper;

import com.serkanguner.movieapp.dto.request.UserRegisterRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRegisterMapper {
    UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);
    User userRegisterRequestDtoToUserRegisterRequestDto(UserRegisterRequestDto dto);
}
