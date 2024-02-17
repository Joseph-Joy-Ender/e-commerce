package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

  //  void deleteProduct(String productName);
}
