package com.services.productcatalog.service;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    ItemDto createItem(ItemDto itemDto);

    ItemDto geItemById(long itemId);

    List<Item> getAllItem();

//    BrandDto updateItem(long itemId);

    void deleteItem(long id);
}
