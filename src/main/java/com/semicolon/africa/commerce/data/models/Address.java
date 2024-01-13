package com.semicolon.africa.commerce.data.models;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {
    @Id
    private Long id;
    private String cityName;
    private String houseNumber;
    private String street;
    private String state;
}
