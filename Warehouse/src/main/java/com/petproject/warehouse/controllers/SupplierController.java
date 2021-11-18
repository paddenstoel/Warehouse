package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.SupplierDto;
import com.petproject.warehouse.services.SupplierService;
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
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
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
        log.info("Method getById of Supplier controller is working");
        log.debug("Get Supplier with id: {}", id);
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SupplierDto> getAll() {
        log.debug("Getting all Suppliers");
        return supplierService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable SupplierDto supplierDto) {
        log.info("Method create of Supplier controller is working");
        log.debug("Create new Supplier: {}", supplierDto);
        supplierService.create(supplierDto);
        return new ResponseEntity<>(supplierDto.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    UUID update(@RequestParam SupplierDto supplierDto) {
        log.info("Method put of Supplier controller is working");
        log.debug("Update Supplier: {}", supplierDto);
        return supplierService.update(supplierDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable UUID id) throws NotFoundException {
        log.info("Method delete of Supplier controller is working");
        log.debug("Delete Supplier with id: {}", id);
        supplierService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
