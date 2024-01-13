package com.semicolon.africa.commerce.services;

import com.semicolon.africa.commerce.data.repositories.CustomerRepository;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterCustomerRequest;
import com.semicolon.africa.commerce.exceptions.CustomerException;
import com.semicolon.africa.commerce.exceptions.InvalidDetailsException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        customerRepository.deleteAll();
    }

    @Test
    public void registerCustomer_countIsOneTest() throws CustomerException {
        RegisterCustomerRequest request = new RegisterCustomerRequest();
        assertEquals(0, customerRepository.count());
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        customerService.register(request);
        assertEquals(1, customerRepository.count());
    }

    @Test
    public void registerACustomer_loginWithWrongEmailAddress_throwAnExceptionTest() throws CustomerException {
        LoginRequest loginRequest = new LoginRequest();
        RegisterCustomerRequest request = new RegisterCustomerRequest();
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        customerService.register(request);

        loginRequest.setPassword("password");
        loginRequest.setEmailAddress("joy828545@Gmail.com.slash");
        assertThrows(InvalidDetailsException.class, () ->  customerService .login(loginRequest));
    }

}