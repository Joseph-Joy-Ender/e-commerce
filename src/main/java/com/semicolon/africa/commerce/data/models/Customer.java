package com.semicolon.africa.commerce.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Customer {
    @Id
    private String id;
    private String username;
    private String age;
    private String emailAddress;
    private String homeAddress;
    private String password;
    private String phoneNumber;
    private ShoppingCart shoppingCart;
}
