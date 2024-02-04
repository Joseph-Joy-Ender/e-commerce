package com.semicolon.africa.commerce.data.repositories;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByProductNameContainingIgnoreCase(String productName);
   Product findProductByProductNameIgnoreCase(String productName);
    List<Product> findProductByCategoryIgnoreCase(String category);
    Product deleteProductByProductNameIgnoreCase(String productName);
}
