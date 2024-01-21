package com.semicolon.africa.commerce.data.repositories;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByProductNameIgnoreCase(String productName);
    Product findProductByCategory(ProductCategory category);
}
