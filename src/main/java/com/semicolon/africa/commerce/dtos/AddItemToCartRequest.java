package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddItemToCartRequest {
    @Positive
    private int quantity;
    @Email
    @Pattern(regexp =  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String emailAddress;
    @NotBlank
    @NotEmpty
    private String productName;
}
