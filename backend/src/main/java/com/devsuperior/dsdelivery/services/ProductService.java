package com.devsuperior.dsdelivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.repositories.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
        ProductRepository productRepository
    ){
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true )
    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAllByOrderByNameAsc();
        return products.stream().map(
            product -> new ProductDto(product)
        ).collect(Collectors.toList());
    }
}
