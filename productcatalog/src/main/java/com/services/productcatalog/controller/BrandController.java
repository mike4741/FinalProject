package com.services.productcatalog.controller;

import com.services.productcatalog.dto.BrandDto;
import com.services.productcatalog.model.Brand;
import com.services.productcatalog.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(value = "http://localhost:5503/**")
@CrossOrigin(origins = "http://127.0.0.1:5503")
@RestController
@RequestMapping("/api/")
public class BrandController {

    private BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping("/brands")
    public ResponseEntity<BrandDto> createType(@RequestBody BrandDto brandDto){
        return new ResponseEntity<BrandDto>(brandService.createBrand(brandDto), HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public List<Brand> getAllPost() {
        return brandService.getAllBrands();

    }
    @GetMapping("brands/{brandId}")
    public Optional<Brand> getTypeById(@PathVariable(value = "typeId") long typeId) {
        return (brandService.geBrandeById(typeId));
    }
}