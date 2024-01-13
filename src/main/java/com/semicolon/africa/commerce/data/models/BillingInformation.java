package com.semicolon.africa.commerce.data.models;

import lombok.Data;

@Data
public class BillingInformation {
    private String receiversPhoneNumber;
    private String receiversName;
    private String deliveryAddress;
    private CreditCardInformation cardInformation;
}
