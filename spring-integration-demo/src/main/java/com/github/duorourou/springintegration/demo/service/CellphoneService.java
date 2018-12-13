package com.github.duorourou.springintegration.demo.service;

import com.github.duorourou.springintegration.demo.user.CreateCellphoneCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CellphoneService {

    @Autowired
    MessageChannel createCellphoneCmdChannel;

    public boolean createCellphone(CreateCellphoneCmd cmd) {
        return createCellphoneCmdChannel.send(MessageBuilder.withPayload(cmd).build());
    }
}
