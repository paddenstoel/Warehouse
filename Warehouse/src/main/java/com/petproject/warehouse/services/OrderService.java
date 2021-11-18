package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.OrderRepository;
import com.petproject.warehouse.dao.entities.Order;
import com.petproject.warehouse.dto.OrderDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    private List<OrderDto> mapListToOrderDto(List<Order> orderList) {
        List<OrderDto> dtoList = new ArrayList<>();
        for (Order or : orderList) {
            dtoList.add(mapToOrderDto(or));
        }
        return dtoList;
    }

    public OrderDto findById(UUID id) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("No Order with id: " + id));
        return mapToOrderDto(order);
    }

    public List<OrderDto> findAll() {
        Iterable<Order> iterable = orderRepository.findAll();
        List<Order> list = new ArrayList<>();
        for (Order c : iterable) {
            list.add(c);
        }
        return mapListToOrderDto(list);
    }

    public UUID create(OrderDto dto) {
        Order order = new Order(dto.getQuantity(), dto.getOrderDate());
        return orderRepository.save(order).getId();
    }

    public void delete(UUID id) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("No Order with id: " + id));
        orderRepository.deleteById(id);
    }
}
