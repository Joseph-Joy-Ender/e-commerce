package com.semicolon.africa.commerce.services.storeService;

import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.data.models.Store;
import com.semicolon.africa.commerce.dtos.StoreCreationRequest;
import com.semicolon.africa.commerce.exceptions.SellerException;
import com.semicolon.africa.commerce.exceptions.StoreException;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreCreationService {
    private final StoreService storeService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;


    public ApiResponse createStore(StoreCreationRequest creationRequest){
        Seller foundSeller = findSellerByEmailAddress(creationRequest.getEmailAddress());
        if (foundSeller == null) throw new SellerException(GenerateApiResponse.SELLER_DOES_NOT_EXIST);
        if (foundSeller.getStore() != null) throw new StoreException(GenerateApiResponse.SELLER_WITH_THIS_ACCOUNT_ALREADY_HAS_A_STORE);
        Store foundStore = findStoreByName(creationRequest.getName());
        if (foundStore != null) throw new StoreException(GenerateApiResponse.STORE_WITH_THIS_NAME_EXIST);
        Store store = modelMapper.map(creationRequest, Store.class);
        Store savedStore = storeService.save(store);
        foundSeller.setStore(savedStore);
        sellerService.save(foundSeller);
        return GenerateApiResponse.create(GenerateApiResponse.STORE_SUCCESSFULLY_CREATED);

    }

    private Store findStoreByName(String name) {
        return storeService.findByName(name);
    }

    private Seller findSellerByEmailAddress(String emailAddress){
        return sellerService.findByEmail(emailAddress);

    }
}
