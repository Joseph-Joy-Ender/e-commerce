package com.semicolon.africa.commerce.data.repositories;

import com.semicolon.africa.commerce.data.models.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
