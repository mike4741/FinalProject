package com.services.productcatalog.dto;


import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class TypeDto {

    int id;
    @NotEmpty (message = "type should not be empty ")
    String type;
}
