package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterCustomerRequest {
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String password;
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    @Email
    @NotBlank
    @NotEmpty
    private String emailAddress;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "[1-9]\\\\d{2}-[1-9]\\\\d{2}-\\\\d{4}")
    private String phoneNumber;
    @NotEmpty
    @NotBlank
    private String homeAddress;
}
