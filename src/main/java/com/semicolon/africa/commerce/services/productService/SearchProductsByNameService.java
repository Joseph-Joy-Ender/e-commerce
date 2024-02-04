package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchProductsByNameService {
    private final ProductService productService;

    public ApiResponse searchByName(String productName){
        List<Product> products = productService.findProductByName(productName.toUpperCase());
        if (products.isEmpty()) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        return GenerateApiResponse.view(products);
    }
}
