package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteProductService {
    private final ProductService productService;

    public ApiResponse deleteProducts(String productName){
        Product product = productService.findProductByProductName(productName);
        if (product.getProductName() == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        productService.deleteProduct(productName);
        return GenerateApiResponse.view(GenerateApiResponse.PRODUCT_DELETED);

    }
}
