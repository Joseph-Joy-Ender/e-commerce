package com.semicolon.africa.commerce.services.productService;

import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.services.sellerService.SellerService;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViewProductService {
   private SellerService sellerService;

    public ApiResponse viewAllProduct(String emailAddress){
        Seller seller = sellerService.findByEmail(emailAddress);
        return GenerateApiResponse.view(seller.getStore().getProducts());
    }

}
