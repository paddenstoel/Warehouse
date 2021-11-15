package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.CustomerRepository;
import com.petproject.warehouse.dao.entities.Customer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findCustomersByFirstName(String firstName) {
        log.info("Method findCustomersByFirstName was called with string firstName parameter...");
        return customerRepository.findByFirstNameStartingWith(firstName);
    }

    public List<Customer> findCustomersByCustomerAddressIsNull() {
        log.info("Method findCustomersByCustomerAddressIsNull was called without parameters...");
        return customerRepository.findByCustomerAddressIsNull();
    }

    public List<Customer> findCustomersByLastNameGreaterThan(String lastName) {
        log.info("Method findCustomersByLastNameGreaterThan was called with string lastName parameter...");
        return customerRepository.findByLastNameGreaterThan(lastName);
    }

}
