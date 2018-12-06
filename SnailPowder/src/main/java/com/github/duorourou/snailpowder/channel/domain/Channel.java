package com.github.duorourou.snailpowder.channel.domain;

import com.github.duorourou.snailpowder.adapter.api.ApiAdapter;
import com.github.duorourou.snailpowder.adapter.mq.MQAdapter;
import com.google.common.base.Strings;

public class Channel {

    private final ApiAdapter inventory;
    private final ApiAdapter srm;
    private final MQAdapter ideal2cChannelMQ;

    public Channel(ApiAdapter inventory, ApiAdapter srm, MQAdapter ideal2cChannelMQ) {
        this.inventory = inventory;
        this.srm = srm;
        this.ideal2cChannelMQ = ideal2cChannelMQ;
    }

    public String create() {
        inventory.get(null, null);
        inventory.post(null, null, null);
        inventory.put(null, null, null);
        inventory.delete(null, null);
        srm.get(null, null);
        ideal2cChannelMQ.emit(null);
        return null;
    }
}
