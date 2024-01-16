package com.semicolon.africa.commerce.services.sellerService;

import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterSellerRequest;
import com.semicolon.africa.commerce.utils.ApiResponse;


public interface SellerService {
    Seller save(Seller seller);
    ApiResponse register(RegisterSellerRequest registerSellerRequest);

    ApiResponse login(LoginRequest loginRequest);

    Seller findByEmail(String sellerEmailAddress);

}
