package com.services.productcatalog.repository.cart;

import com.services.productcatalog.model.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByUserId(String userId);
}
