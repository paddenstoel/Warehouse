package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.services.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> get() {
        log.info("Method get of Customer controller is working");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/filter/firstLetter")
    @ResponseBody
    public ResponseEntity<?> getCustomersByFirstLetter(@RequestParam String firstLetter) {
        log.info("Customer Controller's filterByFirstName method started working...");
        List<CustomerDto> customers = customerService.findCustomersByFirstName(firstLetter);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/filter/addressIsNull")
    @ResponseBody
    public ResponseEntity<?> getCustomersByAddressIsNull() {
        log.info("Customer Controller's filterByAddressIsNull method started working...");
        List<CustomerDto> customers = customerService.findCustomersByCustomerAddressIsNull();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/filter/lastNameGreaterThan")
    @ResponseBody
    public ResponseEntity<?> getCustomersByLastNameGreaterThan(@RequestParam String lastName) {
        log.info("Customer Controller's filterByLastNameGreaterThan method started working with param lastName: {}", lastName);
        List<CustomerDto> customers = customerService.findCustomersByLastNameGreaterThan(lastName);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/filter/birthDay")
    @ResponseBody
    public ResponseEntity<?> getCustomersByBirthDayDate() {
        log.info("Customer Controller's filterCustomersByBirthDayDate method started working without params");
        List<CustomerDto> customers = customerService.findCustomersByBirthDayDate();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable UUID id) throws NotFoundException {
        log.info("Method getById of Customer controller is working");
        log.debug("Get Customer with id: {}", id);
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("Getting all Customers");
        log.info("Customer Controller's getAll method started working");
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@PathVariable CustomerDto customerDto) {
        log.info("Method create of Customer controller is working");
        log.debug("Create new Customer: {}", customerDto);
        customerService.create(customerDto);
        return new ResponseEntity<>(customerDto.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    UUID update(@RequestBody CustomerDto customerDto) {
        log.info("Method update of Customer controller is working");
        log.debug("Update Customer: {}", customerDto);
        return customerService.update(customerDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable UUID id) throws NotFoundException {
        log.info("Method delete of Customer controller is working");
        log.debug("Delete Customer with id: {}", id);
        customerService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
