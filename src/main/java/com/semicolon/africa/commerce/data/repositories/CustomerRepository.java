package com.semicolon.africa.commerce.data.repositories;


import com.semicolon.africa.commerce.data.models.Customer;
import com.semicolon.africa.commerce.data.models.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByEmailAddress(String emailAddress);

    boolean existsByEmailAddress(String emailAddress);
}
