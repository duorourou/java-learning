package com.thoughtworks.duorourou.java.proxy.cglib;

import com.thoughtworks.duorourou.java.proxy.annotation.Proxy;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SonySongPlayer extends SongPlayer {

    @Proxy
    public void repeat(String songName, int times) {
        log.info("Song : {} will repeat {} times.", songName, times);
    }
}
