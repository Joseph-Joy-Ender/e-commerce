package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterSellerRequest {
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String password;
    @Email
    @NotBlank
    @NotEmpty
    private String emailAddress;
    @NotBlank
    @NotEmpty
    private String phoneNumber;
}
