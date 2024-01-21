package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.services.customerService.CustomerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViewCartService {
    private CustomerService customerService;

    public ApiResponse viewCart(String emailAddress) {
        Customer customer = customerService.findByEmailAddress(emailAddress);
        return GenerateApiResponse.view(customer.getShoppingCart().getProducts());
    }
}
