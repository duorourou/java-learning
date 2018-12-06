package com.github.duorourou.snailpowder.core

import com.github.duorourou.snailpowder.adapter.api.ApiAdapter
import com.github.duorourou.snailpowder.adapter.mq.MQAdapter
import com.github.duorourou.snailpowder.channel.domain.Channel
import spock.lang.Specification

class SampleTest extends Specification {
    def mqAdapter = Mock(MQAdapter)
    def inventoryApi = Mock(ApiAdapter)
    def srmApi = Mock(ApiAdapter)

    def setup() {
        mqAdapter = Mock(MQAdapter)
        inventoryApi = Mock(ApiAdapter)
        srmApi = Mock(ApiAdapter)
    }

    def 'it will create a channel'() {
        given: 'A channel with name and code'
        def channel = new Channel(inventoryApi, srmApi, mqAdapter)

        when: 'create a channel'
        channel.create()


        then: 'will create a new inventory to inventory service'
        1 * inventoryApi.post(null, null, null)
        then: 'will update an inventory to inventory service'
        1 * inventoryApi.put(null, null, null)
        then: 'will delete an old inventory to inventory service'
        1 * inventoryApi.delete(null, null)
        then: 'will get srm code from srm service'
        1 * srmApi.get(null, null)
        then: 'will send a message with topic \'123\''
        1 * mqAdapter.emit(*_)
    }
}
