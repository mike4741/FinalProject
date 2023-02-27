package com.services.productcatalog.controller;

import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.dto.ItemsResponce;
import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.service.ItemService;
import com.services.productcatalog.service.TypeService;
import com.services.productcatalog.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://127.0.0.1:5503")
@RestController
@RequestMapping("/api/items")
@Slf4j
public class ItemController {
    private  ItemService  itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody  ItemDto itemDto ){
        System.out.println("one");
        log.info(itemDto.toString());

        return new ResponseEntity<ItemDto>(itemService.createItem(itemDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ItemsResponce getAllItems(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return itemService.getAllItems(pageNo, pageSize, sortBy, sortDir);
    }
}
