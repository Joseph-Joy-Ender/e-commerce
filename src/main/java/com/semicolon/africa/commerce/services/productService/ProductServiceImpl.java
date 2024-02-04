package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.data.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductByProductName(String name) {
        return productRepository.findProductByProductNameIgnoreCase(name);
    }


    @Override
    public List<Product> findProductByName(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }

    @Override
    public Product deleteProduct(String productName) {
        return productRepository.deleteProductByProductNameIgnoreCase(productName);
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return productRepository.findProductByCategoryIgnoreCase(category);
    }


    @Override
    public Object findAll() {
        return productRepository.findAll();
    }
}
