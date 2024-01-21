package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @Email
    private String emailAddress;
    @NotEmpty
    @NotBlank
    private String password;
}
