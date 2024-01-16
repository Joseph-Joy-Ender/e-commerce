package com.semicolon.africa.commerce.controller;


import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.ProductAdditionRequest;
import com.semicolon.africa.commerce.dtos.RegisterSellerRequest;
import com.semicolon.africa.commerce.dtos.StoreCreationRequest;
import com.semicolon.africa.commerce.services.productService.ProductAdditionService;
import com.semicolon.africa.commerce.services.productService.ViewProductService;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import com.semicolon.africa.commerce.services.storeService.StoreCreationService;
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
    private final StoreCreationService creationService;
    private final ProductAdditionService additionService;
    private final ViewProductService productService;

    @PostMapping("registerSeller")
    public ResponseEntity<ApiResponse> registerSeller(@RequestBody RegisterSellerRequest registerSellerRequest) {
        return new ResponseEntity<>(sellerService.register(registerSellerRequest), HttpStatus.CREATED);

    }

    @PostMapping("loginSeller")
    public ResponseEntity<ApiResponse> loginSeller(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(sellerService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("storeCreation")
    public ResponseEntity<ApiResponse> createStore(@RequestBody StoreCreationRequest creationRequest){
        return new ResponseEntity<>(creationService.createStore(creationRequest), HttpStatus.CREATED);
    }

    @PostMapping("addProduct")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductAdditionRequest additionRequest){
        return new ResponseEntity<>(additionService.addProduct(additionRequest), HttpStatus.CREATED);
    }

    @GetMapping("viewProduct/{emailAddress}")
    public ResponseEntity<ApiResponse> viewProduct(@PathVariable String emailAddress){
        return new ResponseEntity<>(productService.viewAllProduct(emailAddress), HttpStatus.OK);
    }

}
