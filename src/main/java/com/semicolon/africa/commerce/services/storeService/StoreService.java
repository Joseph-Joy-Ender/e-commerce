package com.semicolon.africa.commerce.services.storeService;

import com.semicolon.africa.commerce.data.models.Store;

public interface StoreService {
    Store save(Store store);

    Store findByName(String name);
}
