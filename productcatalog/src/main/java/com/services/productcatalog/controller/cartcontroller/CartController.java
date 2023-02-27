package com.services.productcatalog.controller.cartcontroller;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.dto.cartdto.CartDto;
import com.services.productcatalog.dto.cartdto.CartResponse;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.service.BrandService;
import com.services.productcatalog.service.cart.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin(origins = "http://127.0.0.1:5503")
@RestController
@RequestMapping("/api/")
public class CartController {

    private CartService cartService ;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/carts/{itemId}")
    public ResponseEntity<CartDto> addToCart(@PathVariable(name ="itemId")  String itemId ){
log.info(itemId+"at controller cart ");
        return new ResponseEntity<CartDto>(cartService.addToCart(itemId), HttpStatus.CREATED);
    }


    @GetMapping("/carts/{userId}")
    public CartResponse CartResponse(@RequestParam(name ="userId")  String userId ) {
        log.info("controller+++=>"+userId);
        return cartService.getCartByUserId(userId);

    }
}
