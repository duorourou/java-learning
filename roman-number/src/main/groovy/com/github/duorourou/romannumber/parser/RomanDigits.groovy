package com.github.duorourou.romannumber.parser

enum RomanDigits {

    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private magnitude;

    private RomanDigits(magnitude) { this.magnitude = magnitude }

    static BigInteger parse(String numeral) {
        if (numeral == null || numeral.empty) {
            return 0
        }
        def digits = (numeral as List).collect {
            valueOf(it)
        }
        def L = digits.size()
        (0..<L).inject(0g) { total, i ->
            def sign = (i == L - 1 || digits[i] >= digits[i + 1]) ? 1 : -1
            total + sign * digits[i].magnitude
        } as BigInteger
    }

}
