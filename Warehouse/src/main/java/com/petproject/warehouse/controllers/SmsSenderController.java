package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.services.CustomerService;
import com.petproject.warehouse.services.MessageResponse;
import com.petproject.warehouse.services.SmsSender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/messages")
public class SmsSenderController {
    private final SmsSender smsSender;
    private final CustomerService customerService;

    @Autowired
    public SmsSenderController(SmsSender smsSender, CustomerService customerService) {
        this.smsSender = smsSender;
        this.customerService = customerService;
    }

    @GetMapping("/sms")
    @ResponseBody
    public ResponseEntity<?> sendHappyBirthdaySmsMessages() {
        log.info("SMS Sender Controller's sendHappyBirthdaySmsMessages method started working without params");
        List<CustomerDto> customers = customerService.findCustomersByBirthDayDate();
        String congrats = "Happy Birthday!";
        MessageResponse response = smsSender.send(customers, congrats);
        return new ResponseEntity<>(response.printResponse(), HttpStatus.OK);
    }
}
