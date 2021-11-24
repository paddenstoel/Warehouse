package com.petproject.warehouse.services;

import com.petproject.warehouse.dto.CustomerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Log4j2
public class EmailCongratulate implements CongratulateCustomer {

    private final CustomerService customerService;

    @Autowired
    public EmailCongratulate(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void sayHappyBirthday() {
        List<CustomerDto> customers = customerService.findCustomersByBirthDayDate();
        for (CustomerDto customer : customers) {
            log.info("Happy Birthday, " + customer.getFirstName() + "!");
        }
    }
}

