package com.services.productcatalog.service.cart.impl;

import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.dto.cartdto.CartDto;
import com.services.productcatalog.dto.cartdto.CartResponse;
import com.services.productcatalog.model.Item;
import com.services.productcatalog.model.cart.CartItem;
import com.services.productcatalog.repository.ItemRepository;
import com.services.productcatalog.repository.cart.CartRepository;
import com.services.productcatalog.service.cart.CartService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    private ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public CartServiceImpl(CartRepository cartRepository, ModelMapper modelMapper  ,ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
        this.itemRepository =itemRepository;
    }

    @Override
    public CartDto addToCart(String itemId ) {
        log.info(itemId+"data from front end ");
        int quantity =1;
        String userID = "abc@gmail.com";
        CartDto cartDto = new CartDto();

        cartDto.setItemId(itemId);
        cartDto.setUserId(userID);

        CartItem cartItem = mapToEntity(cartDto);
        CartItem newcartItem = cartRepository.save(cartItem);
        return mapToDTO(newcartItem);
    }

    @Override
    public CartResponse getCartByUserId(String userId) {

           List<CartItem>  cartItems = cartRepository.findByUserId(userId);
           List<Item>  inCartList = new ArrayList<>();
        for (CartItem x:cartItems) {
            log.info(x.getItemId());
                 Item data = itemRepository.findById(Long.parseLong(x.getItemId())).get();
                 inCartList.add(data);

        }

        List<ItemDto> listOfItems = inCartList.stream().map(this::mapToDTO).collect(Collectors.toList());
        log.info("FINAL OUT3333"+listOfItems.toString());
        CartResponse xxx = new CartResponse();
        xxx.setItemDto( listOfItems);
        xxx.setUserId(userId);
        log.info("FINAL OUT2"+xxx.toString());
























//
//        log.info("My list of cart item"+cartItems.toString());
//          int numberOfItems = cartItems.size();
//        log.info("number of items "+String.valueOf(numberOfItems));
////        CartResponse cartResponse = new CartResponse();
//
//        List<CartResponse> cartResponses = cartItems.stream().map(this::mapToDTO2).collect(Collectors.toList());
//



        return xxx;
    }
    private ItemDto mapToDTO(Item item) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        return itemDto;
    }


    private CartDto mapToDTO(CartItem cartItem) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CartDto cartDto = modelMapper.map(cartItem, CartDto.class);
        return cartDto;
    }

    private CartItem mapToEntity(CartDto cartDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CartItem cartItem = modelMapper.map(cartDto, CartItem.class);
        return cartItem;
    }

    private CartResponse mapToDTO2(CartItem cartItem) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CartResponse cartResponse = modelMapper.map(cartItem, CartResponse.class);
        return cartResponse;
    }
}
