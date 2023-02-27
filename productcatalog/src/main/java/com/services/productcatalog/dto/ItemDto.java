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
    float price;
    @NotEmpty (message = "pictureURL should not be empty ")
    String pictureURL;

    long brandId;
    long typeId;


}
