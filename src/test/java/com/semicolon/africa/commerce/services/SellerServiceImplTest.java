package com.semicolon.africa.commerce.services;


import com.semicolon.africa.commerce.data.repositories.SellerRepository;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterSellerRequest;
import com.semicolon.africa.commerce.exceptions.InvalidDetailsException;
import com.semicolon.africa.commerce.exceptions.SellerException;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SellerServiceImplTest {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private SellerRepository sellerRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        sellerRepository.deleteAll();
    }

    @Test
    public void registerSeller_countIsOneTest(){
        RegisterSellerRequest request = new RegisterSellerRequest();
        assertEquals(0, sellerRepository.count());
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        sellerService.register(request);
        assertEquals(1, sellerRepository.count());
    }

    @Test
    public void registerSeller_registerSameSellerAgain_throwExceptionTest(){
        RegisterSellerRequest request = new RegisterSellerRequest();
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        sellerService.register(request);
        assertThrows(SellerException.class, ()-> sellerService.register(request));
    }

    @Test
    public void registerTwoSellers_countIsTwoTest(){
        RegisterSellerRequest request = new RegisterSellerRequest();
        assertEquals(0, sellerRepository.count());
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        sellerService.register(request);

        RegisterSellerRequest request2 = new RegisterSellerRequest();
        request2.setPassword("pass");
        request2.setUsername("Jude");
        request2.setPhoneNumber("0901284453");
        request2.setEmailAddress("jude1234@Gmail.com");
        sellerService.register(request2);
        assertEquals(2, sellerRepository.count());
    }

    @Test
    public void registerASeller_loginWithWrongEmailAddress_throwAnExceptionTest(){
        LoginRequest loginRequest = new LoginRequest();
        RegisterSellerRequest request = new RegisterSellerRequest();
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        sellerService.register(request);

        loginRequest.setPassword("password");
        loginRequest.setEmailAddress("joy828545@Gmail.com.slash");
        assertThrows(InvalidDetailsException.class, () ->  sellerService.login(loginRequest));
    }

    @Test
    public void registerASeller_loginWithWrongPassword_throwExceptionTest(){
        LoginRequest loginRequest = new LoginRequest();
        RegisterSellerRequest request = new RegisterSellerRequest();
        request.setPhoneNumber("09018296447");
        request.setEmailAddress("joy828545@Gmail.com");
        request.setUsername("Joy");
        request.setPassword("password");
        sellerService.register(request);

        loginRequest.setPassword("wrongPassword");
        loginRequest.setEmailAddress("joy828545@Gmail.com");
        assertThrows(InvalidDetailsException.class, () ->  sellerService.login(loginRequest));
    }



//    @Test
//    void addProductsTest(){
//        AddProductRequest itemsRequest = new AddProductRequest();
//        itemsRequest.setPrice(BigDecimal.valueOf(500));
//        itemsRequest.setProductName("Iphone6");
//        itemsRequest.setProductDescription("A very good phone to have");
//        sellerService.addProducts(itemsRequest);
//        assertEquals(1, sellerRepository.count());
//
//    }



}