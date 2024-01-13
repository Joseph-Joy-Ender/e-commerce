package com.semicolon.africa.commerce.data.models;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCart {
    private List<Product> products;

}
