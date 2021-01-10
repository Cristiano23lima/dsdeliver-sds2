package com.devsuperior.dsdelivery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsdelivery.dto.OrderDto;
import com.devsuperior.dsdelivery.dto.ProductDto;
import com.devsuperior.dsdelivery.entities.Order;
import com.devsuperior.dsdelivery.entities.Product;
import com.devsuperior.dsdelivery.repositories.OrderRepository;
import com.devsuperior.dsdelivery.repositories.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
        OrderRepository orderRepository
    ){
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true )
    public List<OrderDto> findAll(){
        List<Order> orders = orderRepository.findOrdersWithProducts();
        return orders.stream().map(
            order -> new OrderDto(order)
        ).collect(Collectors.toList());
    }
}
