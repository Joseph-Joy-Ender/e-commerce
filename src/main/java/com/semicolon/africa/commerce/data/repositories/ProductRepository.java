package com.semicolon.africa.commerce.data.repositories;

import com.semicolon.africa.commerce.data.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByProductNameIgnoreCase(String productName);
}
