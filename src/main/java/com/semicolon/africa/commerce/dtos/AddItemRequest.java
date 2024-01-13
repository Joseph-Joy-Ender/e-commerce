package com.semicolon.africa.commerce.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class AddItemRequest {
    private String id;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String emailAddress;
    private String productName;
}
