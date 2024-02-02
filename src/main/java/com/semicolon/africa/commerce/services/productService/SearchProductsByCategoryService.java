package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchProductsByCategoryService {
    private final ProductService productService;
    private final CustomerService customerService;

    public ApiResponse searchProductsByCategory(String category){
        Product product = productService.findProductByCategory(ProductCategory.valueOf(category));
        if (product == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        return GenerateApiResponse.view(productService.findAll());

    }
}
