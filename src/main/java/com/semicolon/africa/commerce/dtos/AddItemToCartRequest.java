package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddItemToCartRequest {
    @Positive
    private BigDecimal quantity;
    @Email
    private String emailAddress;
    @NotBlank
    @NotEmpty
    private String productName;
}
