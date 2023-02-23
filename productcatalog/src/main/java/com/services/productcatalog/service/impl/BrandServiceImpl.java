package com.services.productcatalog.service.impl;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.repository.BrandRepository;
import com.services.productcatalog.service.BrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {


    private  final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = MapToEntity(brandDto);
        Brand  newBrand  = brandRepository.save(brand);

        return mapToDTO(newBrand);
    }



    @Override
    public Optional<Brand> geBrandeById(long brandId) {
        return brandRepository.findById(brandId);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public BrandDto updateBrand(long brandId, String brand) {
        return null;
    }

    @Override
    public void deleteBrand(long id) {

    }

    private BrandDto mapToDTO(Brand brand) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        BrandDto brandDto = modelMapper.map(brand, BrandDto.class);
        return brandDto;
    }

    private Brand MapToEntity(BrandDto brandDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Brand brand = modelMapper.map(brandDto, Brand.class);
        return brand;
    }
}
