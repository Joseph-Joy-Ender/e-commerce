package com.semicolon.africa.commerce.services.customerService;

import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.data.repositories.CustomerRepository;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.exceptions.InvalidDetailsException;
import com.semicolon.africa.commerce.services.cartService.ShoppingCartService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ShoppingCartService shoppingCartService;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    @Override
    public ApiResponse register(RegisterCustomerRequest registerCustomerRequest) throws CustomerException {
        if (checkIfCustomerExist(registerCustomerRequest.getEmailAddress())) throw new CustomerException(GenerateApiResponse.CUSTOMER_ALREADY_EXIST);
        Customer customer = modelMapper.map(registerCustomerRequest, Customer.class);
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart savedCart = shoppingCartService.save(cart);
        customer.setShoppingCart(savedCart);
        customerRepository.save(customer);
        return GenerateApiResponse.create(GenerateApiResponse.CUSTOMER_SUCCESSFULLY_REGISTERED);
    }

    @Override
    public ApiResponse login(LoginRequest loginRequest) {
            Customer foundCustomer = customerRepository.findByEmailAddress(loginRequest.getEmailAddress());
            if (!checkIfCustomerExist(loginRequest.getEmailAddress())) throw new InvalidDetailsException(GenerateApiResponse.LOGIN_CREDENTIALS_IS_INVALID);
            if (!foundCustomer.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException(GenerateApiResponse.LOGIN_CREDENTIALS_IS_INVALID);
            customerRepository.save(foundCustomer);
            return GenerateApiResponse.loginSuccessful(GenerateApiResponse.LOGIN_SUCCESSFUL);
    }


    @Override
    public Customer findByEmailAddress(String emailAddress) {
        return customerRepository.findByEmailAddress(emailAddress);
    }



    private boolean checkIfCustomerExist(String emailAddress) {
        Customer foundCustomer = customerRepository.findByEmailAddress(emailAddress);
        return foundCustomer != null;
    }



}
