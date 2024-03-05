package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DeleteFromCartServiceTest {
    @Autowired
    private DeleteFromCartService deleteFromCartService;

    @Test
    public void customerCanDeleteFromCart(){
        String productName = "Frying pan";
        String emailAddress = "joy828545@Gmail.com";
       // deleteFromCartService.deleteProduct(productName, emailAddress);
        assertEquals(GenerateApiResponse.view(GenerateApiResponse.PRODUCT_DELETED).getHttpStatus(), deleteFromCartService.deleteProduct(productName, emailAddress).getHttpStatus());

    }

}