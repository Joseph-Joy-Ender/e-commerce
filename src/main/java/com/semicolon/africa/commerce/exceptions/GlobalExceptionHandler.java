package com.semicolon.africa.commerce.exceptions;

import com.semicolon.africa.commerce.utils.ExceptionApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SellerException.class)
    public ResponseEntity<ExceptionApiResponse> userException(SellerException sellerException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(sellerException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidDetailsException.class)
    public ResponseEntity<ExceptionApiResponse> invalidDetails(InvalidDetailsException invalidDetailsException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(invalidDetailsException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StoreException.class)
    public ResponseEntity<ExceptionApiResponse> storeExist(StoreException storeException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(storeException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ExceptionApiResponse> productExist(ProductException productException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(productException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CartException.class)
    public ResponseEntity<ExceptionApiResponse> customerNotFound(CartException cartException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(cartException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ExceptionApiResponse> customerException(CustomerException customerException){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(customerException.getMessage())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionApiResponse> validateInputException(){
        return new ResponseEntity<>(ExceptionApiResponse.builder()
                .data(GenerateApiResponse.FILL_ALL_FIELDS_CORRECTLY)
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }

}
