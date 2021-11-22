package com.petproject.warehouse.services;

import com.petproject.warehouse.dao.CustomerRepository;
import com.petproject.warehouse.dao.entities.Customer;
import com.petproject.warehouse.dto.CustomerDto;
import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    public List<CustomerDto> findCustomersByBirthDayDate() {
        log.info("Method findCustomersByBirthDayDate was called without parameters");
        List<Customer> customers = customerRepository.findCustomersByBirthDayDate();
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

    private List<CustomerDto> mapListToCustomerDto(List<Customer> customerList) {
        List<CustomerDto> dtoList = new ArrayList<>();
        for (Customer c : customerList) {
            dtoList.add(mapToCustomerDto(c));
        }
        return dtoList;
    }

    public CustomerDto findById(UUID id) throws NotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("No Customer with id: " + id));
        return mapToCustomerDto(customer);
    }

    public List<CustomerDto> findAll() {
        Iterable<Customer> iterable = customerRepository.findAll();
        List<Customer> list = new ArrayList<>();
        for (Customer c : iterable) {
            list.add(c);
        }
        return mapListToCustomerDto(list);
    }

    public UUID update(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new IllegalStateException("No Customer with id: " + customerDto.getId()));
        return customerRepository.save(customer).getId();
    }

    public UUID create(CustomerDto dto) {
        Customer customer = new Customer(dto.getLastName(), dto.getFirstName(), dto.getCustomerContactNumber(), dto.getCustomerAddress());
        return customerRepository.save(customer).getId();
    }

    public void delete(UUID id) throws NotFoundException {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("No Customer with id: " + id));
        customerRepository.deleteById(id);
    }
}
