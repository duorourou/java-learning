package com.github.duorourou.snailpowder.adapter.mq

interface MQAdapter {

    def <R, B> R emit(Message<B> message)

}
