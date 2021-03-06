package com.petproject.warehouse.services.notifications;

import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.services.MessageCode;
import com.petproject.warehouse.services.MessageResponse;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class EMailSender implements NotificationSend {
    @Override
    public MessageResponse send(List<CustomerDto> recipients, String text) {
        for (CustomerDto recipient : recipients) {
            log.info("Method send in EMail sender service with params recipients: {} and text: {} is working", recipients, text);
            log.info("Message " + text + " was sent to " + recipient.getFirstName());
        }
        return new MessageResponse(MessageCode.SENT);
    }
}

