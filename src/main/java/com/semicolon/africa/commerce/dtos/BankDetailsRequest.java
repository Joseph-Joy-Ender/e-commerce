package com.semicolon.africa.commerce.dtos;

import lombok.Data;

@Data
public class BankDetailsRequest {
    private String bankName;
    private String accountName;
    private String accountNumber;
}
