package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.data.repositories.CustomerRepository;
import com.semicolon.africa.commerce.dtos.AddItemRequest;
import com.semicolon.africa.commerce.exceptions.CartException;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.exceptions.ProductException;
import com.semicolon.africa.commerce.services.CustomerService;
import com.semicolon.africa.commerce.services.productService.ProductService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CartAdditionCartService {
    private final CustomerService customerService;
    private final ProductService productService;
    private final ShoppingCartService cartService;

    public ApiResponse addToCart(AddItemRequest addItemRequest) throws CustomerException {
        Customer customer = customerService.findByEmailAddress(addItemRequest.getEmailAddress());
        if (customer == null) throw new CustomerException(GenerateApiResponse.CUSTOMER_NOT_FOUND);
        Product product = productService.findProductById(addItemRequest.getId());
        if (product == null) throw new ProductException(GenerateApiResponse.PRODUCT_NOT_FOUND);
        ShoppingCart ShoppingCart = customer.getShoppingCart();
        List<Product> listOfProducts = ShoppingCart.getProducts();
        if(listOfProducts==null){
            listOfProducts = new ArrayList<>();
        }

        listOfProducts.add(product);

        ShoppingCart.setProducts(new ArrayList<>(listOfProducts));
        ShoppingCart updatedShoppingCart = cartService.save(ShoppingCart);

        customer.setShoppingCart(updatedShoppingCart);

        customerService.save(customer);

        return GenerateApiResponse.added(GenerateApiResponse.PRODUCT_SUCCESSFULLY_ADDED_TO_CART);
    }
}
