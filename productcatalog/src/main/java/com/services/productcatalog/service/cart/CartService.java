package com.services.productcatalog.service.cart;

import com.services.productcatalog.dto.cartdto.CartDto;
import com.services.productcatalog.dto.cartdto.CartResponse;
import org.springframework.stereotype.Service;


@Service

public interface CartService {
    CartDto addToCart(String itemId);

    CartResponse getCartByUserId(String userId);

//    public void updateCart(String id) {
//
//    }
//
//    public void deleteCart(String id) {
//
//    }
//    void deleteCart(String id);
}
