package com.thoughtworks.text.composition.duorourou.stopwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {

    @Test
    void shouldDelay10Seconds() throws InterruptedException {
        long sleepTime = 5 * 1000L;
        long executeTime = Clock.executeTime(sleepTime);
        assertEquals(executeTime, 5); // compare in second, in most of cases, the time will be same
    }

}