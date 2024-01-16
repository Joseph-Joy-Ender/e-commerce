package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterCustomerRequest {
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String password;
    @Email
    private String emailAddress;
    private String phoneNumber;
    private String homeAddress;
}
