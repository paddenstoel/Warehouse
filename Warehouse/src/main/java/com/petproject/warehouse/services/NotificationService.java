package com.petproject.warehouse.services;

import com.petproject.warehouse.services.notifications.NotificationSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {
    @Autowired
    private Map<String, NotificationSend> notificationSendMap;

    @Autowired
    @Qualifier("notificationBeans")
    private Map<String, NotificationSend> notificationBeans;

    public void viewMapContent() {
        for (Map.Entry<String, NotificationSend> entry : notificationSendMap.entrySet()) {
            System.out.println("key =  " + entry.getKey() + " value " + entry.getValue().toString());
        }
    }

    public void viewContentMyMap() {
        for (Map.Entry<String, NotificationSend> entry : notificationBeans.entrySet()) {
            System.out.println("key =  " + entry.getKey() + " value " + entry.getValue().toString());
        }
    }
}
