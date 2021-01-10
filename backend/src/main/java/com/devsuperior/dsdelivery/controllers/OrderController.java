package com.devsuperior.dsdelivery.controllers;

import java.net.URI;
import java.util.List;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.services.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(
        OrderService service
    ){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                    .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}