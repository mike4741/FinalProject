package com.services.productcatalog.controller;

import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.dto.TypeResponse;
import com.services.productcatalog.model.Type;
import com.services.productcatalog.service.TypeService;
import com.services.productcatalog.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(value = "http://localhost:5503/**")
@CrossOrigin(origins = "http://127.0.0.1:5503")
@RestController
@RequestMapping("/api/")
public class TypeController {

    private TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
   @PostMapping("types")
    public ResponseEntity<TypeDto> save(@RequestBody TypeDto typeDto){
        return new ResponseEntity<TypeDto>(typeService.createType(typeDto), HttpStatus.CREATED);
    }
    @GetMapping("types")
    public List<Type> getAllPost() {
        return typeService.getAllTypes();

    }
    @GetMapping("types/{typeId}")
    public TypeDto getTypeById(@PathVariable(value = "typeId") long typeId) {
        return (typeService.getTypeById(typeId));
    }



}
