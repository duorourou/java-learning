package com.thoughtworks.duorourou.stopwatch;

public class StopWatch {
    private long startMills;
    private long stopMills;

    public static final long NANOS_PER_SEC = 1_000_000_000L;

    public void start() {
        startMills = System.nanoTime();
    }

    public void stop() {
        stopMills = System.nanoTime();
    }

    public long getTime() {
        return (stopMills - startMills) / NANOS_PER_SEC;
    }
}
