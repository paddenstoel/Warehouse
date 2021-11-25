package com.petproject.warehouse.services;

import com.petproject.warehouse.dto.CustomerDto;

import java.util.List;

public interface MessageSend {

    MessageResponse send(List<CustomerDto> recipients, String text);

}
