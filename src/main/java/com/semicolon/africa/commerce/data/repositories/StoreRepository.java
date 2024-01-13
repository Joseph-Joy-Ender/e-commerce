package com.semicolon.africa.commerce.data.repositories;

import com.semicolon.africa.commerce.data.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String> {
    Store findByNameIgnoreCase(String name);
}
