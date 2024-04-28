package com.serkanguner.movieapp.repository;


import com.serkanguner.movieapp.dto.request.EmailAndPasswordRequestDTO;
import com.serkanguner.movieapp.dto.request.UserLoginRequestDto;
import com.serkanguner.movieapp.dto.request.UserRegisterRequestDto;
import com.serkanguner.movieapp.dto.response.EmailFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserNameFindAllOrderBy;
import com.serkanguner.movieapp.dto.response.UserReturnIdDto;
import com.serkanguner.movieapp.entity.MovieComment;
import com.serkanguner.movieapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Query(value = "SELECT u FROM User u WHERE length(u.password)>:x and u.name =:y")
    List<User> checkPasswordLengthThanArgJPQL(@Param("x") int length,@Param("y") String name);

    List<User> findAllFavmoviesByName(String name);

    List<User> findAllById(Long id);

//    List<User> findAllCommentsByDateBetweenAndById(LocalDate start, LocalDate end,Long Id);






}
