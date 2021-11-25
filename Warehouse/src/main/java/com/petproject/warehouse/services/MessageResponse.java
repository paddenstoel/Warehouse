package com.petproject.warehouse.services;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public class MessageResponse {
    private MessageCode messageCode;

    public MessageResponse(MessageCode messageCode) {
        this.messageCode = messageCode;
    }

    public MessageCode printResponse() {
        return MessageCode.SENT;
    }
}
