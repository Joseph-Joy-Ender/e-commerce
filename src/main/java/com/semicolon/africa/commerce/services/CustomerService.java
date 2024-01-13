package com.semicolon.africa.commerce.services;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.dtos.RegisterRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.utils.ApiResponse;

public interface CustomerService {
    ApiResponse register(RegisterCustomerRequest registerCustomerRequest) throws CustomerException;
    ApiResponse login(LoginRequest loginRequest);
    ApiResponse addToCart(Product product, String emailAddress);

    Customer findByEmailAddress(String emailAddress);

    Customer save(Customer customer);
}
