package com.github.duorourou.springintegration.demo.config;

import com.github.duorourou.springintegration.demo.user.CellphoneCreatedEvent;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Payload;

@MessageEndpoint
public class LogActivator {

    @ServiceActivator
    public void logMessage(@Payload CellphoneCreatedEvent event) {
        System.out.println("Cellphone create : " + event.toString());
    }
}
