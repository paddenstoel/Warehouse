package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.ProductDto;
import com.petproject.warehouse.services.ProductService;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
        log.info("Method getById of Product controller is working");
        log.debug("Get Product with id: {}", id);
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<ProductDto> getAll() {
        log.debug("Getting all Products");
        return productService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable ProductDto productDto) {
        log.info("Method create of Product controller is working");
        log.debug("Create new Product: {}", productDto);
        productService.create(productDto);
        return new ResponseEntity<>(productDto.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    UUID update(@RequestParam ProductDto productDto) {
        log.info("Method update of Product controller is working");
        log.debug("Update Product: {}", productDto);
        return productService.update(productDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable UUID id) throws NotFoundException {
        log.info("Method delete of Product controller is working");
        log.debug("Delete Product with id: {}", id);
        productService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
