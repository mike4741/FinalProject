package com.services.productcatalog.dto.cartdto;

import com.services.productcatalog.dto.ItemDto;
import com.services.productcatalog.model.Item;
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
public class CartResponse {

    List<ItemDto> itemDto ;
    String userId;

}
