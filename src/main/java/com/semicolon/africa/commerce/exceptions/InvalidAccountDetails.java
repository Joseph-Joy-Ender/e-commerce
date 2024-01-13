package com.semicolon.africa.commerce.exceptions;

public class InvalidAccountDetails extends RuntimeException{
    public InvalidAccountDetails(String message){
        super(message);
    }
}
