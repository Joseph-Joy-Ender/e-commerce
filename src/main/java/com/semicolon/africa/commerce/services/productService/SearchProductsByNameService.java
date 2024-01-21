package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchProductsByNameService {
    private final ProductService productService;
    private final CustomerService customerService;

    public ApiResponse searchProductsByName(ProductCategory category){
        Product product = productService.findProductByCategory(category);
        return GenerateApiResponse.view(product.getCategory());

    }
}
