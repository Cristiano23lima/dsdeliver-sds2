package com.devsuperior.dsdelivery.controllers;

import java.util.List;

import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.services.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService service;

    public ProductController(
        ProductService service
    ){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
