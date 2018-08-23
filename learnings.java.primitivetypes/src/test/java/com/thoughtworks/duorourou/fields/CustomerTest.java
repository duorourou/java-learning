package com.thoughtworks.duorourou.fields;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CustomerTest {

    @Test
    public void classFieldShouldShareTheValueBetweenDifferentInstances() {
        Customer tom = new Customer("Tom");
        tom.sign();

        assertEquals(1, Customer.SIGN_IN_COUNT);

        Customer john = new Customer("John");
        john.sign();

        assertEquals(2, Customer.SIGN_IN_COUNT);

        // actually we do not use the follow way to use the class field, just to show they are same in different instance
        assertEquals(tom.SIGN_IN_COUNT, john.SIGN_IN_COUNT);
    }

    @Test
    public void instanceFieldsShouldNotShareTheValueBetweenDifferentInstances() {
        Customer tom = new Customer("Tom");
        tom.sign();

        Customer john = new Customer("John");
        john.sign();

        assertNotEquals(john.name, tom.name);
    }
}