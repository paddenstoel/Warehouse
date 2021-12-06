package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.OrderDto;
import com.petproject.warehouse.services.OrderService;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/lombok")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable UUID id) throws NotFoundException {
        log.info("Method getById of Order controller is working");
        log.debug("Get Order with id: {}", id);
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("Getting all Orders");
        log.info("Method getAll of Order controller is working\"");
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable OrderDto orderDto) {
        log.info("Method post of Order controller is working");
        log.debug("Create new Order: {}", orderDto);
        orderService.create(orderDto);
        return new ResponseEntity<>(orderDto.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    UUID update(@RequestBody OrderDto orderDto) {
        log.info("Method put of Order controller is working");
        log.debug("Update Order: {}", orderDto);
        return orderService.update(orderDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable UUID id) throws NotFoundException {
        log.info("Method delete of Order controller is working");
        log.debug("Delete Order with id: {}", id);
        orderService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
