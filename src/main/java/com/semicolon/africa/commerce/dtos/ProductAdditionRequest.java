package com.semicolon.africa.commerce.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductAdditionRequest {
    private String productName;
    private BigDecimal price;
    private String productDescription;
    private String category;
    private String sellerEmailAddress;

}
