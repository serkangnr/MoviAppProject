package com.serkanguner.movieapp.controller;
import static com.serkanguner.movieapp.constant.EndPoints.*;

import com.serkanguner.movieapp.dto.request.UserLoginRequestDto;
import com.serkanguner.movieapp.dto.request.UserRegisterRequestDto;
import com.serkanguner.movieapp.dto.request.UserSaveRequestDto;
import com.serkanguner.movieapp.dto.response.EmailFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserFindAllResponseDto;
import com.serkanguner.movieapp.dto.response.UserLoginResponseDto;
import com.serkanguner.movieapp.dto.response.UserNameFindAllOrderBy;
import com.serkanguner.movieapp.entity.User;
import com.serkanguner.movieapp.exception.ErrorType;
import com.serkanguner.movieapp.exception.MovieAppException;
import com.serkanguner.movieapp.repository.UserRepository;
import com.serkanguner.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ROOT + USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<UserLoginResponseDto> doLogin(String email, String password){
        return userService.userLoginDto(email, password);
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<String> doRegister(@RequestBody UserRegisterRequestDto dto){
        userService.userRegisterDto(dto);
        return ResponseEntity.ok("Kayit Basarili");

    }

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<String> save(@RequestBody UserSaveRequestDto dto){
        userService.userSaveDto(dto);
        return ResponseEntity.ok("Kayit Basarili");
    }
    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(){
        return ResponseEntity.ok(userService.findUserDto());
    }

    @GetMapping("/FindUserByOrder")
    @CrossOrigin("*")
    public ResponseEntity<List<UserNameFindAllOrderBy>> findUserDescDto(){
        return ResponseEntity.ok(userService.findAllByOrderName());
    }

    @GetMapping("/FindUserByName/{name}")
    @CrossOrigin("*")
    public ResponseEntity<List<UserNameFindAllOrderBy>> findUserByNameDto(@PathVariable String name){
        return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(name));
    }

    @GetMapping("/FindUserByEmail/{email}")
    @CrossOrigin("*")
    public ResponseEntity<List<EmailFindAllResponseDto>> findUserByEmailDto(@PathVariable String email){
        return ResponseEntity.ok(userService.findAllByEmailContainingIgnoreCase(email));
    }

    @GetMapping("/FindUserByEmailEnding/{email}")
    @CrossOrigin("*")
    public ResponseEntity<List<EmailFindAllResponseDto>> findAllByEmailEndingWithIgnoreCase(@PathVariable String email){
        return ResponseEntity.ok(userService.findAllByEmailEndingWithIgnoreCase(email));
    }

    @GetMapping("/FindUserByEmailAndPassword/{email},{password}")
    @CrossOrigin("*")
    public Boolean existByEmailAndPassword(@PathVariable String email , @PathVariable String password){
        return userService.existsByEmailAndPassword(email,password);
    }




}
