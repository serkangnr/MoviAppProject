package com.serkanguner.movieapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;

public record UserRegisterRequestDto(String email, String password, String repassword) {
}
