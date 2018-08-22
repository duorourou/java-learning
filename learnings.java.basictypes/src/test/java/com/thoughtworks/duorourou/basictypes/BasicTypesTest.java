package com.thoughtworks.duorourou.basictypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicTypesTest {

    @Test
    public void shouldHasDefaultValue() {
        BasicTypes basicTypes = new BasicTypes();
        assertEquals(0, basicTypes.byteVariable);
        assertEquals(0, basicTypes.shortVariable);
        assertEquals(0, basicTypes.intVariable);
        assertEquals(0L, basicTypes.longVariable);
        assertEquals(0F, basicTypes.floatVariable);
        assertEquals(0D, basicTypes.doubleVariable);
        assertEquals(0, basicTypes.charVariable);

        assertFalse(basicTypes.booleanVariable); // equal with assertEquals(false, basicTypes.booleanVariable)
        assertNull(basicTypes.stringVariable); // equal with assertEquals(null, basicTypes.stringVariable);
    }

    @Test
    public void numberVariableShouldHasMinAndMaxValues() {
        assertEquals(-128, Byte.MIN_VALUE);
        assertEquals(127, Byte.MAX_VALUE);
        assertThrows(NumberFormatException.class, () -> Byte.valueOf("128"));
        assertThrows(NumberFormatException.class, () -> Byte.valueOf("-129"));

        assertEquals(Byte.MAX_VALUE, (byte) (Byte.MIN_VALUE - 1));
        assertEquals(Byte.MIN_VALUE, (byte) (Byte.MAX_VALUE + 1));
        // Minimum byte value is -128, that is 10000000 in binary. so -128 - 1 will be 10000000 - 00000001 = 011111111, and 011111111 is 127 in decimal.
        // Similar with -128 - 1, the maximum value of byte type is 01111111 in binary. 01111111 + 00000001 = 10000000 that is -128.

//        byte: 8-bit signed . minimum value of -128 and maximum value of 127 (inclusive).
    }
}