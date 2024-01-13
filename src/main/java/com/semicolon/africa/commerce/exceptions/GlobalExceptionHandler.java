package com.semicolon.africa.commerce.exceptions;

import com.semicolon.africa.commerce.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SellerException.class)
    public ResponseEntity<ApiResponse> userException(SellerException sellerException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(sellerException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDetailsException.class)
    public ResponseEntity<ApiResponse> invalidDetails(InvalidDetailsException invalidDetailsException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(invalidDetailsException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StoreException.class)
    public ResponseEntity<ApiResponse> storeExist(StoreException storeException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(storeException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ApiResponse> productExist(ProductException productException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(productException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CartException.class)
    public ResponseEntity<ApiResponse> customerNotFound(CartException cartException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(cartException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ApiResponse> customerException(CustomerException customerException){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(customerException.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
