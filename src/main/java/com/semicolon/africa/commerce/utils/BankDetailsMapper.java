package com.semicolon.africa.commerce.utils;


import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.dtos.BankDetailsRequest;

public class BankDetailsMapper {
    public static Seller bankMapper(BankDetailsRequest detailsRequest){
        Seller seller = new Seller();
        seller.setAccountName(detailsRequest.getAccountName());
        seller.setAccountNumber(detailsRequest.getAccountNumber());
        seller.setBankName(detailsRequest.getBankName());
        return seller;
    }
}
