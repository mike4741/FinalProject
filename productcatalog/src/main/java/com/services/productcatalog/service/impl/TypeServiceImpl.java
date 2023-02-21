package com.services.productcatalog.service.impl;

import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.model.Type;
import com.services.productcatalog.repository.TypeRepository;
import com.services.productcatalog.service.TypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl  implements TypeService {


    private  final TypeRepository typeRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository , ModelMapper modelMapper  ) {
        this.typeRepository = typeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TypeDto createType(TypeDto typeDto)
    {
        Type type = MapToEntity(typeDto);
        Type  newType  = typeRepository.save(type);

        return mapToDTO(newType);

    }



    @Override
    public TypeDto getTypeById(long typeId) {

        return typeRepository.findAllById(typeId);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public TypeDto updateType(long typeId, String name) {
        return null;
    }

    @Override
    public void deleteType(long id) {

    }


    private Type MapToEntity(TypeDto typeDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Type type = modelMapper.map(typeDto, Type.class);
        return type;
    }

    private TypeDto mapToDTO(Type type) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeDto typeDto = modelMapper.map(type, TypeDto.class);
        return typeDto;
    }
}
