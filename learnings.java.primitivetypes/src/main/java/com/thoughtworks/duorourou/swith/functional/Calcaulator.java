package com.thoughtworks.duorourou.swith.functional;

import java.util.Map;

public class Calcaulator {

    public static int calculate(int first, int second, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            default:
                result = 0;
        }
        return result;
    }

    private static final Calculable UNSUPPORTED_OPERATION = (first, second) -> 0;
    private static final Map<Character, Calculable> CALCULATORS =
            Map.ofEntries(
                    Map.entry('+', (first, second) -> first + second),
                    Map.entry('-', (first, second) -> first - second),
                    Map.entry('*', (first, second) -> first * second));

    public static int calculate2(int first, int second, char operation) {
        return CALCULATORS.getOrDefault(operation, UNSUPPORTED_OPERATION).calculate(first, second);
    }

    interface Calculable {
        int calculate(int first, int second);
    }
}
