package com.semicolon.africa.commerce.data.models;

import lombok.Data;

@Data
public class CreditCardInformation {
    private String cvv;
    private String expiryDate;
    private long creditCardNumber;
    private String nameOnCard;
    private CardType cardType;
}
