package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAdditionRequest {
    @NotEmpty
    @NotBlank
    private String productName;
    @NotEmpty
    @NotBlank
    private BigDecimal price;
    @NotEmpty
    @NotBlank
    private String productDescription;
    @NotEmpty
    @NotBlank
    private String category;
    @NotEmpty
    @NotBlank
    @Email
    private String sellerEmailAddress;

}
