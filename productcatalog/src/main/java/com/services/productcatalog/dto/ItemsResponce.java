package com.services.productcatalog.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemsResponce {
    List<ItemDto> itemDtos;
    int pageNo;
    int pageSize;
    long totalElements;
    int totalPages;
    boolean last;

}
