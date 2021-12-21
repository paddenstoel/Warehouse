package com.petproject.warehouse.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "notifications")
public class NotificationProperties {

    private final Map<String, Notification> notifications = new HashMap<>();

    public Map<String, Notification> getNotifications() {
        return notifications;
    }

    @Getter
    @Setter
    public static class Notification {
        private boolean isChannelEnabled;
        private String name;
    }
}
