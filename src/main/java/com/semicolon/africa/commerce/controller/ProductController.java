package com.semicolon.africa.commerce.controller;

import com.semicolon.africa.commerce.dtos.ProductAdditionRequest;
import com.semicolon.africa.commerce.services.productService.ProductAdditionService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/e-commerce/")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {
    private final ProductAdditionService additionService;

    @PostMapping("addProduct")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductAdditionRequest additionRequest){
        return new ResponseEntity<>(additionService.addProduct(additionRequest), HttpStatus.CREATED);
    }
}
