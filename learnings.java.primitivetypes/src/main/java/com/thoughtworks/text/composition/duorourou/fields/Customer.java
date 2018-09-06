package com.thoughtworks.text.composition.duorourou.fields;

public class Customer {
    /**
     * class field, another name is 'static field'
     */
    static int SIGN_IN_COUNT = 0;

    /**
     * instance variable, another name is 'non-static field'
     */
    final String name;
    private boolean isSigned = Boolean.FALSE;

    public Customer(String name) {
        this.name = name;
    }

    public void sign() {
        if (!isSigned) {
            SIGN_IN_COUNT++;
            this.isSigned = true;
        }
    }

}
