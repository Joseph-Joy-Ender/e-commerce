package com.semicolon.africa.commerce.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {
    public static final String SELLER_SUCCESSFULLY_REGISTERED = "Seller account was successfully created";
    public static final String SELLER_ALREADY_EXIST = "Seller with this information already exist";
    public static final String LOGIN_CREDENTIALS_IS_INVALID = "Login credentials is not valid";
    public static final String LOGIN_SUCCESSFUL = "Login was successful";
    public static final String CUSTOMER_ALREADY_EXIST = "customer with this information already exist";
    public static final String CUSTOMER_SUCCESSFULLY_REGISTERED = "Customer account successfully created";
    public static final String SELLER_DOES_NOT_EXIST = "Seller does not exist";
    public static final String STORE_SUCCESSFULLY_CREATED = "Seller store has successfully been created";
    public static final String STORE_WITH_THIS_NAME_EXIST = "Store with this name exist";
    public static final String SELLER_WITH_THIS_ACCOUNT_ALREADY_HAS_A_STORE = "Seller with this account already has a store";
    public static final String PRODUCT_ADDED_SUCCESSFULLY = "Product has been added successfully";
    public static final String SELLER_NOT_FOUND = "Seller is not found";
    public static final String STORE_NOT_CREATED = "Seller store not created";
    public static final String PRODUCT_EXIST = "This product already exist in your store";
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String PRODUCT_NOT_FOUND = "Product is not found";
    public static final String PRODUCT_SUCCESSFULLY_ADDED_TO_CART = "Product successfully added to cart";
    public static final String FILL_ALL_FIELDS_CORRECTLY = "Kindly fill all fields correctly";

    public static ApiResponse created(Object data) {
               return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse create(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse loginSuccessful(Object data){
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse added(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse view(Object data) {
        return ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();

    }
}
