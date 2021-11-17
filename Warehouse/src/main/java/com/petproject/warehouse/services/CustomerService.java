package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.CustomerRepository;
import com.petproject.warehouse.dao.entities.Customer;
import com.petproject.warehouse.dto.CustomerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> findCustomersByFirstName(String firstName) {
        log.info("Method findCustomersByFirstName was called with string firstName = {} parameter", firstName);
        List<Customer> customers = customerRepository.findByFirstNameStartingWith(firstName);
        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> findCustomersByCustomerAddressIsNull() {
        log.info("Method findCustomersByCustomerAddressIsNull was called without parameters");
        List<Customer> customers = customerRepository.findByCustomerAddressIsNull();
        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> findCustomersByLastNameGreaterThan(String lastName) {
        log.info("Method findCustomersByLastNameGreaterThan was called with string lastName = {} parameter", lastName);
        List<Customer> customers = customerRepository.findByLastNameGreaterThan(lastName);
        return customers.stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerDto mapToCustomerDto(Customer customerEntity) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customerEntity.getId());
        dto.setLastName(customerEntity.getLastName());
        dto.setFirstName(customerEntity.getFirstName());
        dto.setCustomerContactNumber(customerEntity.getCustomerContactNumber());
        dto.setCustomerAddress(customerEntity.getCustomerAddress());
        return dto;
    }

    public Customer mapToCustomerEntity(CustomerDto dto) {
        Customer customerEntity = new Customer();
        customerEntity.setId(dto.getId());
        customerEntity.setLastName(dto.getLastName());
        customerEntity.setFirstName(dto.getFirstName());
        customerEntity.setCustomerContactNumber(dto.getCustomerContactNumber());
        customerEntity.setCustomerAddress(dto.getCustomerAddress());
        return customerEntity;
    }

}
