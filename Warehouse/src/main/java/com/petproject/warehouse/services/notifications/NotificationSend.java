package com.petproject.warehouse.services.notifications;

import com.petproject.warehouse.dto.CustomerDto;
import com.petproject.warehouse.services.MessageResponse;

import java.util.List;

public interface NotificationSend {

    MessageResponse send(List<CustomerDto> recipients, String text);

}
