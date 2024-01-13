package com.semicolon.africa.commerce.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Seller {
    @Id
    private String id;
    private String username;
    private String age;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String bankName;
    private String accountName;
    private String accountNumber;
    private Store store;

}
