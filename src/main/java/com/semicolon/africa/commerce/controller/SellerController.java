package com.semicolon.africa.commerce.controller;


import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterRequest;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/e-commerce/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping("registerSeller")
    public ResponseEntity<ApiResponse> registerSeller(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(sellerService.register(registerRequest), HttpStatus.CREATED);

    }

    @PostMapping("loginSeller")
    public ResponseEntity<ApiResponse> loginSeller(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(sellerService.login(loginRequest), HttpStatus.OK);
    }
}
