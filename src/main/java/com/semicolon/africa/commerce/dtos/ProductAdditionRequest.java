package com.semicolon.africa.commerce.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAdditionRequest {
    @NotEmpty
    @NotBlank
    private String productName;
    @Positive
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
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String sellerEmailAddress;
    private int quantity;

}
