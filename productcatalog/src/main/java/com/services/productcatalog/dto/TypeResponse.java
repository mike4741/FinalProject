package com.services.productcatalog.dto;

import com.services.productcatalog.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeResponse {
    private List<TypeDto> content;

}
