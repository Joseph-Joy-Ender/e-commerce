package com.semicolon.africa.commerce.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@Data
public class Store {
    @Id
    private String id;
    private String name;
    private String emailAddress;
    private List<Product> products;
}
