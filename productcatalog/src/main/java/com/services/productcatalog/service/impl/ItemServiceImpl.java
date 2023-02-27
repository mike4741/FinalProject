package com.services.productcatalog.service.impl;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.dto.ItemsResponce;
import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.exception.ResourceNotFoundException;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.model.Item;
import com.services.productcatalog.model.Type;
import com.services.productcatalog.repository.BrandRepository;
import com.services.productcatalog.repository.ItemRepository;
import com.services.productcatalog.repository.TypeRepository;
import com.services.productcatalog.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper,
                           BrandRepository brandRepository,
                           TypeRepository typeRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto ) {

        Item item = MapToEntity(itemDto);
        long brandId =itemDto.getBrandId();
        long typeId =itemDto.getBrandId();
        Brand brand = brandRepository.findById(itemDto.getBrandId()).orElseThrow(() ->
                new ResourceNotFoundException("brand", "id", brandId));

        Type type = typeRepository.findById(typeId).orElseThrow(() ->
                new ResourceNotFoundException("type", "id", typeId));

        item.setBrand(brand);
        item.setType(type);
        Item newItem = itemRepository.save(item);

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

    @Override
    public ItemsResponce getAllItems(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Item> pageItems = itemRepository.findAll(pageable);
        List<Item> items = pageItems.getContent();
        List<ItemDto> listOfItems = items.stream().map(this::mapToDTO).collect(Collectors.toList());

        ItemsResponce itemsResponce = new ItemsResponce();

        itemsResponce.setItemDtos(listOfItems);
        itemsResponce.setPageNo(pageItems.getNumber());
        itemsResponce.setTotalElements(pageItems.getTotalElements());
        itemsResponce.setTotalPages(pageItems.getTotalPages());
        itemsResponce.setPageSize(pageItems.getSize());
        itemsResponce.setLast(pageItems.isLast());

        return itemsResponce;
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
