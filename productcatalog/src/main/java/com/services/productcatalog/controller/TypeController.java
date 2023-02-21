package com.services.productcatalog.controller;

import com.services.productcatalog.dto.TypeDto;
import com.services.productcatalog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    private TypeService typeService;
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
   @PostMapping("/create")
    public ResponseEntity<TypeDto> createType(@RequestBody TypeDto typeDto){
        return new ResponseEntity<TypeDto>(typeService.createType(typeDto), HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String getItems(){
        return  "itemService.getAllItems()";
    }
}
