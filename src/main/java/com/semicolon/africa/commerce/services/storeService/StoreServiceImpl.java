package com.semicolon.africa.commerce.services.storeService;

import com.semicolon.africa.commerce.data.models.Store;
import com.semicolon.africa.commerce.data.repositories.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store findByName(String name) {
        return storeRepository.findByNameIgnoreCase(name);
    }
}
