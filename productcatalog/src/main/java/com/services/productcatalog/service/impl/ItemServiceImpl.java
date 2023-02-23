package com.services.productcatalog.service.impl;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.model.Item;
import com.services.productcatalog.model.Type;
import com.services.productcatalog.repository.BrandRepository;
import com.services.productcatalog.repository.ItemRepository;
import com.services.productcatalog.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private  final ItemRepository itemRepository ;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {

        Item item = MapToEntity(itemDto);
        Item  newItem  = itemRepository.save(item);

        return mapToDTO(newItem);

    }

    @Override
    public ItemDto geItemById(long itemId) {
        return null;
    }

    @Override
    public List<Item> getAllItem() {
        return null;
    }

    @Override
    public void deleteItem(long id) {

    }

    private Item MapToEntity(ItemDto itemDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Item item = modelMapper.map(itemDto, Item.class);
        return item;
    }

    private ItemDto mapToDTO(Item item) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        return itemDto;
    }
}
