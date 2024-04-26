package com.serkanguner.movieapp.repository;


import com.serkanguner.movieapp.dto.request.EmailAndPasswordRequestDTO;
import com.serkanguner.movieapp.dto.request.UserLoginRequestDto;
import com.serkanguner.movieapp.dto.request.UserRegisterRequestDto;
import com.serkanguner.movieapp.dto.response.EmailFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserNameFindAllOrderBy;
import com.serkanguner.movieapp.dto.response.UserReturnIdDto;
import com.serkanguner.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOptionalByEmailAndPassword(String email, String password);

    List<UserNameFindAllOrderBy> findAllByOrderByName();

    List<UserNameFindAllOrderBy> findAllByNameContainingIgnoreCase(String value);

    List<EmailFindAllResponseDto> findAllByEmailContainingIgnoreCase(String value);

    List<EmailFindAllResponseDto> findAllByEmailEndingWithIgnoreCase(String value);

    Boolean existsByEmailAndPassword(String email, String password);




}
