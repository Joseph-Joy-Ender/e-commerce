package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;

public interface ProductService {
    Product save(Product product);
    Product findProductById(String id);
    Product findProductByName(String name);
    Product findProductByCategory(ProductCategory category);

}
