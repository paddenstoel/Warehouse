package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.OrderRepository;
import com.petproject.warehouse.dao.entities.Order;
import com.petproject.warehouse.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto mapToOrderDto(Order orderEntity) {
        OrderDto dto = new OrderDto();
        dto.setId(orderEntity.getId());
        dto.setQuantity(orderEntity.getQuantity());
        dto.setOrderDate(orderEntity.getOrderDate());
        return dto;
    }

    public Order mapToOrderEntity(OrderDto dto) {
        Order orderEntity = new Order();
        orderEntity.setId(dto.getId());
        orderEntity.setQuantity(dto.getQuantity());
        orderEntity.setOrderDate(dto.getOrderDate());
        return orderEntity;
    }
}
