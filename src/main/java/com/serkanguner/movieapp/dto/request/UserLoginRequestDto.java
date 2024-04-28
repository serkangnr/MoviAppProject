package com.serkanguner.movieapp.dto.request;

import jakarta.validation.constraints.Email;

public record UserLoginRequestDto(@Email String email, String password) {
}
