package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.dtos.AddItemToCartRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.services.productService.ProductService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartAdditionService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final ShoppingCartService cartService;

    public ApiResponse addToCustomerCart(AddItemToCartRequest addItemToCartRequest) throws CustomerException {
        Customer customer = customerService.findByEmailAddress(addItemToCartRequest.getEmailAddress());
        if (customer == null) throw new CustomerException(GenerateApiResponse.CUSTOMER_NOT_FOUND);
        Product product = productService.findProductByProductName(addItemToCartRequest.getProductName());
        if (product == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        ShoppingCart shoppingCart = customer.getShoppingCart();
        List<Product> listOfProducts = shoppingCart.getProducts();
        if(listOfProducts == null){
            listOfProducts = new ArrayList<>();
        }

        listOfProducts.add(product);

        shoppingCart.setProducts(new ArrayList<>(listOfProducts));

        ShoppingCart updatedShoppingCart = cartService.save(shoppingCart);

        customer.setShoppingCart(updatedShoppingCart);

        customerService.save(customer);

        return GenerateApiResponse.added(GenerateApiResponse.PRODUCT_SUCCESSFULLY_ADDED_TO_CART);
    }

}
