package com.serkanguner.movieapp.service;

import com.serkanguner.movieapp.dto.request.EmailAndPasswordRequestDTO;
import com.serkanguner.movieapp.dto.request.UserLoginRequestDto;
import com.serkanguner.movieapp.dto.request.UserRegisterRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.dto.response.*;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import com.serkanguner.movieapp.exception.ErrorType;
import com.serkanguner.movieapp.exception.GlobalExceptionHandler;
import com.serkanguner.movieapp.exception.MovieAppException;
import com.serkanguner.movieapp.mapper.MovieMapper;
import com.serkanguner.movieapp.mapper.UserLoginMapper;
import com.serkanguner.movieapp.mapper.UserMapper;
import com.serkanguner.movieapp.mapper.UserRegisterMapper;
import com.serkanguner.movieapp.repository.UserRepository;
import com.serkanguner.movieapp.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService extends ServiceManager<User, Long> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public void userRegisterDto(@RequestBody UserRegisterRequestDto dto) {
        Boolean isUser = existsByEmailAndPassword(dto.email(), dto.password());
        if (isUser) {
            throw new RuntimeException("Kullanici zaten mevcut");
        }else {
            userRepository.save(UserRegisterMapper.INSTANCE.userRegisterRequestDtoToUserRegisterRequestDto(dto));
        }

    }





    public void userSaveDto(UserSaveRequestDto dto) {
        userRepository.save(UserMapper.INSTANCE.dtoToUser(dto));
    }

    public List<UserFindAllResponseDto> findUserDto() {
        List<UserFindAllResponseDto> userFindAllResponseDtos = new ArrayList<>();

        findAll().forEach(user -> {
            userFindAllResponseDtos.add(UserMapper.INSTANCE.userToUserFindAllResponseDto(user));
        });
        return userFindAllResponseDtos;
    }

    public List<UserNameFindAllOrderBy> findAllByOrderName(){
        return userRepository.findAllByOrderByName();
    }

    public List<UserNameFindAllOrderBy> findAllByNameContainingIgnoreCase(String value){
        return userRepository.findAllByNameContainingIgnoreCase(value);
    }

    public List<EmailFindAllResponseDto> findAllByEmailContainingIgnoreCase(String value){
        return userRepository.findAllByEmailContainingIgnoreCase(value);
    }

    public List<EmailFindAllResponseDto> findAllByEmailEndingWithIgnoreCase(String value){
        return userRepository.findAllByEmailEndingWithIgnoreCase(value);
    }

    public Boolean existsByEmailAndPassword(String email, String password){
        return userRepository.existsByEmailAndPassword(email, password);
    }



    public ResponseEntity<UserLoginResponseDto> userLoginDto(String email, String password) {
//        Boolean isUser = existsByEmailAndPassword(email, password);
        Optional<User> user = userRepository.findOptionalByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(UserLoginMapper.INSTANCE.userToUserLoginResponseDto(user.get())) ;
        }
        throw new MovieAppException(ErrorType.USER_NOT_FOUND,"User not found");
    }

    public List<UserFavMovies> findAllFavoriteMovieByName(String name){
        return userRepository.findAllFavmoviesByName(name).stream()
                .map(UserMapper.INSTANCE::movieToUserFavMovies)
                .collect(Collectors.toList());
    }

    public List<UserCommentsDto> findAllById(Long id){
        return userRepository.findAllById(id).stream()
               .map(UserMapper.INSTANCE::userToUserCommentsDto)
               .collect(Collectors.toList());
    }

//    public List<UserCommentsDto>findAllCommentsByDateBetweenAndById(LocalDate start, LocalDate end, Long id){
//        List<User> allCommentByDateBetweenById = userRepository.findAllCommentsByDateBetweenAndById(start, end, id);
//        return allCommentByDateBetweenById.stream().map(UserMapper.INSTANCE::userToUserCommentsDto).collect(Collectors.toList());
//    }




    //
}