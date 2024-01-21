package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class StoreCreationRequest {
    @NotEmpty
    @NotBlank
    private String name;
    @Email
    @NotBlank
    @NotEmpty
    private String emailAddress;
}
