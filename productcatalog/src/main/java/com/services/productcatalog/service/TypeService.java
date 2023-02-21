package com.services.productcatalog.service;

import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.model.Type;

import java.util.List;

public interface TypeService {


    TypeDto createType(TypeDto typeDto);

    TypeDto getTypeById(long typeId);

   List<Type> getAllTypes();

    TypeDto updateType(long typeId, String name);

    void deleteType(long id);
}
