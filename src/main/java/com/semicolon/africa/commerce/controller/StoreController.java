package com.semicolon.africa.commerce.controller;

import com.semicolon.africa.commerce.dtos.StoreCreationRequest;
import com.semicolon.africa.commerce.services.storeService.StoreCreationService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/e-commerce/")
@CrossOrigin("*")
@AllArgsConstructor
public class StoreController {
    private final StoreCreationService creationService;

    @PostMapping("storeCreation")
    public ResponseEntity<ApiResponse> createStore(@RequestBody StoreCreationRequest creationRequest){
        return new ResponseEntity<>(creationService.createStore(creationRequest), HttpStatus.CREATED);
    }
}
