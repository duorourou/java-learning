package com.thoughtworks.duorourou.java.proxy.cglib;

public class Main {
    public static void main(String[] args) {
        ProxyGenerator generator = new ProxyGenerator();
        SonySongPlayer player = generator.build(SonySongPlayer.class);
//        player.play();
//        player.pause();
//        player.next();
//        player.last();
        player.repeat("A New Song", 2);
    }
}
