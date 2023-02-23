package com.services.productcatalog.service;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    BrandDto createBrand(BrandDto brandDto);

    Optional<Brand> geBrandeById(long brandId);

    List<Brand> getAllBrands();

    BrandDto updateBrand(long brandId, String brand);

    void deleteBrand(long id);
}
