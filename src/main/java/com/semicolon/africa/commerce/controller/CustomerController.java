package com.semicolon.africa.commerce.controller;

import com.semicolon.africa.commerce.dtos.AddItemToCartRequest;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.services.cartService.CartAdditionService;
import com.semicolon.africa.commerce.services.cartService.DeleteFromCartService;
import com.semicolon.africa.commerce.services.cartService.ViewCartService;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.services.productService.SearchProductsByCategoryService;
import com.semicolon.africa.commerce.services.productService.SearchProductsByNameService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/e-commerce/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CartAdditionService additionService;
    private final ViewCartService viewCartService;
    private final SearchProductsByCategoryService productsByCategoryService;
    private final SearchProductsByNameService productsByNameService;
    private final DeleteFromCartService deleteFromCartService;

    @PostMapping("registerCustomer")
    public ResponseEntity<ApiResponse> registerCustomer(@RequestBody @Valid RegisterCustomerRequest registerRequest) throws CustomerException {
        return new ResponseEntity<>(customerService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("loginCustomer")
    public ResponseEntity<ApiResponse> loginCustomer(@RequestBody @Valid LoginRequest loginRequest){
        return new ResponseEntity<>(customerService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("addToCart")
    public ResponseEntity<ApiResponse> addToCustomersCart(@RequestBody @Valid AddItemToCartRequest addItemToCartRequest) throws CustomerException {
        return new ResponseEntity<>(additionService.addToCustomerCart(addItemToCartRequest), HttpStatus.CREATED);
    }

    @GetMapping("viewCart/{emailAddress}")
    public ResponseEntity<ApiResponse> viewCart(@PathVariable String emailAddress) {
        return new ResponseEntity<>(viewCartService.viewCart(emailAddress), HttpStatus.OK);
    }

    @GetMapping("searchByCategory/{category}")
    public ResponseEntity<ApiResponse> searchByCategory(@PathVariable String category){
        return new ResponseEntity<>(productsByCategoryService.searchProductsByCategory(category), HttpStatus.FOUND);
    }

    @GetMapping("searchProductByName/{productName}")
    public ResponseEntity<ApiResponse> searchProductByName(@PathVariable String productName){
        return new ResponseEntity<>(productsByNameService.searchByName(productName), HttpStatus.FOUND);
    }

//    @DeleteMapping("deleteProductByName/{productName}")
//    public ResponseEntity<ApiResponse> deleteProducts(@PathVariable String productName){
//        return new ResponseEntity<>(deleteFromCartService.deleteProduct(productName), HttpStatus.OK);
//    }



}
