package com.thoughtworks.duorourou.primitivetypes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimitiveTypesTest {

    @Test
    public void shouldHasDefaultValue() {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();
        assertEquals(0, primitiveTypes.byteVariable);
        assertEquals(0, primitiveTypes.shortVariable);
        assertEquals(0, primitiveTypes.intVariable);
        assertEquals(0L, primitiveTypes.longVariable);
        assertEquals(0F, primitiveTypes.floatVariable);
        assertEquals(0D, primitiveTypes.doubleVariable);
        assertEquals(0, primitiveTypes.charVariable);

        assertFalse(primitiveTypes.booleanVariable); // equal with assertEquals(false, PrimitiveTypes.booleanVariable)
        assertNull(primitiveTypes.stringVariable); // equal with assertEquals(null, PrimitiveTypes.stringVariable);
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

    @Test
    public void shouldHasSameValueWhenUseUnderscore() {
        // Use underscore to separate a number
        assertEquals(31, 3_1);
        assertEquals(31, 3__1);
        assertEquals(31L, 3__1L);
        assertEquals(31F, 3__1F);
        assertEquals(31.02F, 3__1.02F);
        assertEquals(31.02F, 3__1.0_2F);
        assertEquals(333333333333L, 333_333_333_333L);
    }

    @Test
    public void stringTestCases() {

        // 1. should have same value when 2 string compare
        assertEquals("string1st", "string1st");
        // 2. should same
        assertSame("string1st", "string1st");

        // 3. "string2nd" should equals with new String("string2nd") but not same
        assertEquals("string2nd", new String("string2nd"));
        assertNotSame("string2nd", new String("string2nd"));

        // 4 new String("string3rd") should equal with new String("string3rd") but not same
        assertEquals(new String("string3rd"), new String("string3rd"));
        assertNotSame(new String("string3rd"), new String("string3rd"));

        // 5 String pool
        assertSame("string4th", "string" + "4th");

        // 6 String object + "" will use StringBuffer to calculate the result
        assertNotSame("string5th", "string" + new String("5th"));
    }
}