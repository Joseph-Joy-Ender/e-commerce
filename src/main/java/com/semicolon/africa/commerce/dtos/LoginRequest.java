package com.semicolon.africa.commerce.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailAddress;
    private String password;
}
