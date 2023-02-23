package com.services.productcatalog.dto;

import com.services.productcatalog.model.Brand;
import com.services.productcatalog.model.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
@Data
public class ItemDto {

    int id;
    @NotEmpty (message = "name should not be empty ")
    String name;
    String description;
    @NotEmpty (message = "price should not be empty ")
    Double price;
    @NotEmpty (message = "pictureURL should not be empty ")
    String pictureURL;
    @NotEmpty (message = "type should not be empty ")
    int typeId;
    @NotEmpty(message = "brand should not be empty ")
    int brandId;
}
