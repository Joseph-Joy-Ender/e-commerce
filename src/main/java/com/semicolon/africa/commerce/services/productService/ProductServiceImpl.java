package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductByName(String productName) {
        return productRepository.findByProductNameIgnoreCase(productName);
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }
}
