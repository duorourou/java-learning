package com.thoughtworks.duorourou.swith.functional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void shouldCalculateTheResultWithGivenOperation() {
        int addInSwitchResult = Calcaulator.calculate(10, 5, '+');
        int addInNoneSwitchResult = Calcaulator.calculate2(10, 5, '+');
        assertEquals(15, addInSwitchResult);
        assertEquals(addInNoneSwitchResult, addInSwitchResult);
    }

}