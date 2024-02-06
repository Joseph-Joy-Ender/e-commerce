package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Product;
import com.semicolon.africa.commerce.data.models.ProductCategory;
import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.data.models.Store;
import com.semicolon.africa.commerce.dtos.ProductAdditionRequest;
import com.semicolon.africa.commerce.exceptions.SellerException;
import com.semicolon.africa.commerce.exceptions.StoreException;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import com.semicolon.africa.commerce.services.storeService.StoreService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductAdditionService {
    private final ProductService productService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;
    private final StoreService storeService;

    public ApiResponse addProduct(ProductAdditionRequest productAdditionRequest){
        Seller seller = sellerService.findByEmail(productAdditionRequest.getSellerEmailAddress());
        if (seller == null) throw new SellerException(GenerateApiResponse.SELLER_DOES_NOT_EXIST);
        Store store = seller.getStore();
        if (seller.getStore() == null) throw new StoreException(GenerateApiResponse.STORE_NOT_CREATED);

        Product savedProduct = getNewlyCreatedAndSavedProduct(productAdditionRequest);
        List<Product> foundListOfProducts = getListOfProductsFromExistingStore(store);
        savingStoreToSeller(foundListOfProducts, savedProduct, store, seller);

       return GenerateApiResponse.created(GenerateApiResponse.PRODUCT_ADDED_SUCCESSFULLY);
    }


    private void savingStoreToSeller(List<Product> foundListOfProducts, Product savedProduct, Store store, Seller seller) {
        foundListOfProducts.add(savedProduct);
        store.setProducts(new ArrayList<>(foundListOfProducts));
        Store updatedStore = storeService.save(store);
        seller.setStore(updatedStore);
        sellerService.save(seller);
    }

    private Product getNewlyCreatedAndSavedProduct(ProductAdditionRequest productAdditionRequest) {

        Product product = modelMapper.map(productAdditionRequest, Product.class);
        product.setCategory(String.valueOf(ProductCategory.valueOf(productAdditionRequest.getCategory().toUpperCase())));

        return productService.save(product);
    }

    private static List<Product> getListOfProductsFromExistingStore(Store store) {
        List<Product> foundListOfProducts = store.getProducts();
        if (foundListOfProducts == null){
            foundListOfProducts = new ArrayList<>();
        }
        return foundListOfProducts;
    }
}
