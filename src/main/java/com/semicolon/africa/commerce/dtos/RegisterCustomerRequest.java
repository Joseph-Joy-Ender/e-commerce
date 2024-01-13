package com.semicolon.africa.commerce.dtos;

import lombok.Data;

@Data
public class RegisterCustomerRequest {
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String homeAddress;
}
