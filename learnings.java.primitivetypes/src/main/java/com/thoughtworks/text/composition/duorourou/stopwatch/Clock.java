package com.thoughtworks.text.composition.duorourou.stopwatch;

public class Clock {

    static void timer(long mills) throws InterruptedException {
        Thread.sleep(mills);
    }

    static long executeTime(long executeMills) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        timer(executeMills);
        stopWatch.stop();
        return stopWatch.getTime();
    }
}
