package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.productService.ProductService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteFromCartService {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    public ApiResponse deleteProduct(String productName){
      //  ShoppingCart shoppingCart = shoppingCartService
//        Product = productService.findProductByProductName(productName);
//        if (product == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
//        productService.deleteProduct(productName);
        return GenerateApiResponse.view(GenerateApiResponse.PRODUCT_DELETED);
    }
}
