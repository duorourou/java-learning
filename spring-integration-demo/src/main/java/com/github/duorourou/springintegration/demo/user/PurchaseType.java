package com.github.duorourou.springintegration.demo.user;

public enum PurchaseType {
    SELF_SUPPORTING("自营"),
    SALES_BY_PROXY("代销");

    private String value;

    PurchaseType(String value) {
        this.value = value;
    }
}
