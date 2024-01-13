package com.semicolon.africa.commerce.services.cartService;

import com.semicolon.africa.commerce.data.models.ShoppingCart;
import com.semicolon.africa.commerce.data.repositories.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private  final ShoppingCartRepository shoppingCartRepository;
    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }
}


