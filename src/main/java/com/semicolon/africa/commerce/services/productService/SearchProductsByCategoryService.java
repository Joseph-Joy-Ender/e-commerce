package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchProductsByCategoryService {
    private final ProductService productService;


    public ApiResponse searchProductsByCategory(String category){
        List<Product> products = productService.findProductByCategory(category.toUpperCase());
        if (products.isEmpty()) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        return GenerateApiResponse.view(products);

    }
}
