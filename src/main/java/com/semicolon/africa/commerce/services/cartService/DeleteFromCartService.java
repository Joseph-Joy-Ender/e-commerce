package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.services.productService.ProductService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeleteFromCartService {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;
    private final CustomerService customerService;

    public ApiResponse deleteProduct(String productName, String emailAddress){
        Customer customer = customerService.findByEmailAddress(emailAddress);
        ShoppingCart cart = customer.getShoppingCart();
        List<Product> products = cart.getProducts();
         products.remove(productService.findProductByProductName(productName));
       // shoppingCartService.deleteProduct(productName);
      //  ShoppingCart = shoppingCartService
//        Product = productService.findProductByProductName(productName);
//        if (product == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
//        productService.deleteProduct(productName);
        return GenerateApiResponse.view(GenerateApiResponse.PRODUCT_DELETED);
    }
}
