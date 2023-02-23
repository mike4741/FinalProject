package com.services.productcatalog.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
@Data
public class BrandDto {

    int id;
    @NotEmpty(message = "brand should not be empty ")
    String brand;
}
