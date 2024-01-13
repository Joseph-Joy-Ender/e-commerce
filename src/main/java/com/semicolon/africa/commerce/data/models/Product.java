package com.semicolon.africa.commerce.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@Data
public class Product {
    @Id
    private String Id;
    private String productName;
    private BigDecimal price;
    private String productDescription;
    private ProductCategory category;
}
