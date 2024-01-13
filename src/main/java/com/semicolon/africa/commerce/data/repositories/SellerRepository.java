package com.semicolon.africa.commerce.data.repositories;


import com.semicolon.africa.commerce.data.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String> {
    Seller findByEmailAddress(String emailAddress);
}
