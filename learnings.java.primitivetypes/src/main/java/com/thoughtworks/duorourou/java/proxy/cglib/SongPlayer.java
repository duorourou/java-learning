package com.thoughtworks.duorourou.java.proxy.cglib;

import com.thoughtworks.duorourou.java.proxy.annotation.Proxy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SongPlayer {

    @Proxy
    public void play() {
       log.info("Song playing...");
    }

    @Proxy
    public void pause() {
        log.info("Song paused.");
    }

    public void next() {
        log.info("Next song is 'It's Yesterday'...");
    }

    public void last() {
        log.info("Last song is 'Yesterday Once more'");
    }
}
