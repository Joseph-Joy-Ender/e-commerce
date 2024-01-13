package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;

public interface ProductService {
    Product save(Product product);

    Product findProductByName(String productName);
    Product findProductById(String id);
}
