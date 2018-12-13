package com.github.duorourou.springintegration.demo.config;

import com.github.duorourou.springintegration.demo.user.Cellphone;
import com.github.duorourou.springintegration.demo.user.CellphoneCreatedEvent;
import com.github.duorourou.springintegration.demo.user.CreateCellphoneCmd;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import java.util.Date;

@MessageEndpoint
public class CommandActivator {

    @ServiceActivator
    public Message<CellphoneCreatedEvent> handler(@Payload CreateCellphoneCmd cmd) {
        Cellphone cellphone = cmd.getCellphone();
        CellphoneCreatedEvent event = create(cellphone);
        return MessageBuilder.withPayload(event).build();
    }

    private CellphoneCreatedEvent create(Cellphone cellphone) {
        System.out.println("-cellphone created-" + cellphone.getName());
        return CellphoneCreatedEvent.builder().cellphone(cellphone).createdDate(new Date()).build();
    }
}
