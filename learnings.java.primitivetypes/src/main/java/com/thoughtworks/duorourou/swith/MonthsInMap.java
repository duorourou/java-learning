package com.thoughtworks.duorourou.swith;

import java.util.Map;

/**
 * An example to show using Map to eliminate switch/case
 */
public class MonthsInMap {
    private static final String INVALID_MONTH = "Invalid month";
    private static final Map<Integer, String> MONTHS =
            Map.ofEntries(
                    Map.entry(1, "January"),
                    Map.entry(2, "February"),
                    Map.entry(3, "March"),
                    Map.entry(4, "April"),
                    Map.entry(5, "May"),
                    Map.entry(6, "June"),
                    Map.entry(7, "July"),
                    Map.entry(8, "August"),
                    Map.entry(9, "September"),
                    Map.entry(10, "October"),
                    Map.entry(11, "November"),
                    Map.entry(12, "December"));

    public static String month(int month) {
        return MONTHS.getOrDefault(month, INVALID_MONTH);
    }
}
