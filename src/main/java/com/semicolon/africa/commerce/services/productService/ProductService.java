package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;

import java.util.List;

public interface ProductService {
    Product save(Product product);
   // Product findProductById(String id);
    Product findProductByProductName(String name);
    List<Product> findProductByCategory(String category);
    List<Product> findProductByName(String productName);
    Product deleteProduct(String productName);


    Object findAll();
}
