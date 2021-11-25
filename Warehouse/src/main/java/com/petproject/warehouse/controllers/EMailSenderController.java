package com.petproject.warehouse.controllers;

import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.services.CustomerService;
import com.petproject.warehouse.services.EMailSender;
import com.petproject.warehouse.services.MessageResponse;
import lombok.Getter;
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
@Getter
@RequestMapping("/messages")
public class EMailSenderController {

    private final EMailSender eMailSender;
    private final CustomerService customerService;

    @Autowired
    public EMailSenderController(EMailSender eMailSender, CustomerService customerService) {
        this.eMailSender = eMailSender;
        this.customerService = customerService;
    }

    @GetMapping("/emails")
    @ResponseBody
    public ResponseEntity<?> sendHappyBirthdayEMailMessages() {
        log.info("EMailSender Controller's sendHappyBirthdayEMailMessages method started working without params");
        List<CustomerDto> customers = customerService.findCustomersByBirthDayDate();
        String congrats = "Happy Birthday!";
        MessageResponse response = eMailSender.send(customers, congrats);
        return new ResponseEntity<>(response.printResponse(), HttpStatus.OK);
    }
}
