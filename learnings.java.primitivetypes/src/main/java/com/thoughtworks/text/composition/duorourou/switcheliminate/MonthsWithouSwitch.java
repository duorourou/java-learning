package com.thoughtworks.text.composition.duorourou.switcheliminate;

/**
 * An example to show how to eliminate switch/case
 */
public class MonthsWithouSwitch {
    private static final String INVALID_MONTH = "Invalid month";
    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static String month(int month) {
        if (isValidMonthNumber(month)) {
            return MONTHS[month - 1];
        }
        return INVALID_MONTH;
    }

    private static boolean isValidMonthNumber(int month) {
        return month > 0 && month < 13;
    }
}
