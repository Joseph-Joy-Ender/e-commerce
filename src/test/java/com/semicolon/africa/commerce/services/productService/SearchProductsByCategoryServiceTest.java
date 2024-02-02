package com.semicolon.africa.commerce.services.productService;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@AllArgsConstructor
class SearchProductsByCategoryServiceTest {
    private final SearchProductsByCategoryService products;

    @Test
    void testThatProductCanBeFoundByCategory(){
        String category = "ELECTRONICS";
      //  assertEquals(2, products.searchProductsByCategory(category));

    }

}