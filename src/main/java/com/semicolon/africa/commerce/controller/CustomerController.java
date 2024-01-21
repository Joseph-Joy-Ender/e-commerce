package com.semicolon.africa.commerce.controller;

import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.dtos.AddItemToCartRequest;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.services.cartService.ViewCartService;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.services.cartService.CartAdditionService;
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
    private final SearchProductsByNameService productsByNameService;

    @PostMapping("registerCustomer")
    public ResponseEntity<ApiResponse> registerCustomer(@RequestBody @Valid RegisterCustomerRequest registerRequest) throws CustomerException {
        return new ResponseEntity<>(customerService.register(registerRequest), HttpStatus.CREATED);
    }

    @PostMapping("loginCustomer")
    public ResponseEntity<ApiResponse> loginCustomer(@RequestBody @Valid LoginRequest loginRequest){
        return new ResponseEntity<>(customerService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("addToCustomersCart")
    public ResponseEntity<ApiResponse> addToCustomersCart(@RequestBody @Valid AddItemToCartRequest addItemToCartRequest) throws CustomerException {
        return new ResponseEntity<>(additionService.addToCustomersCart(addItemToCartRequest), HttpStatus.CREATED);
    }

    @GetMapping("viewCart/{emailAddress}")
    public ResponseEntity<ApiResponse> viewCart(@PathVariable String emailAddress) {
        return new ResponseEntity<>(viewCartService.viewCart(emailAddress), HttpStatus.OK);
    }

    @GetMapping("searchProductsByName{category}")
    public ResponseEntity<ApiResponse> searchProductsByName(@PathVariable ProductCategory category){
        return new ResponseEntity<>(productsByNameService.searchProductsByName(category), HttpStatus.FOUND);
    }


}
