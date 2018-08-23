package com.thoughtworks.duorourou.switcheliminate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthsTest {

    @Test
    void shouldFindMonthStringWhenGiveMonthNumber() {
        Months months = new Months();

        assertEquals("February", months.month(2));
        assertEquals("March", months.month(3));
        assertEquals("May", months.month(5));
        assertEquals("August", months.month(8));
        assertEquals("Invalid month", months.month(0));
        assertEquals("Invalid month", months.month(13));
    }

}