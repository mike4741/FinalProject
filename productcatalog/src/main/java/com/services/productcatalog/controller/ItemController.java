package com.services.productcatalog.controller;

import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.service.ItemService;
import com.services.productcatalog.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private  ItemService  itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){

//
        return new ResponseEntity<ItemDto>(itemService.createItem(itemDto), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String getItems(){
        return  "testItemController";
    }
}
