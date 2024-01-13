package com.semicolon.africa.commerce.controller;

import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.dtos.RegisterRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.services.CustomerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("registerCustomer")
    public ResponseEntity<ApiResponse> registerCustomer(@RequestBody RegisterCustomerRequest registerRequest) throws CustomerException {
        return new ResponseEntity<>(customerService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("loginCustomer")
    public ResponseEntity<ApiResponse> loginCustomer(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(customerService.login(loginRequest), HttpStatus.OK);
    }
}
