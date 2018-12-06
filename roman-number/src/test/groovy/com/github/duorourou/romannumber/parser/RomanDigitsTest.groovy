package com.github.duorourou.romannumber.parser

import spock.lang.Specification

class RomanDigitsTest extends Specification {

    def "convert a roman number to arabic"() {
        expect:
        RomanDigits.parse(roman) == arabic

        where:
        roman     | arabic
        ""        | 0
        "I"       | 1
        "II"      | 2
        "III"     | 3
        "V"       | 5
        "M"       | 1000
        "MCXI"    | 1111
        "CMXI"    | 911
        "MCM"     | 1900
        "MCMXC"   | 1990
        "MMVIII"  | 2008
        "MMIX"    | 2009
        "MCDXLIV" | 1444
        "MDCLXVI" | 1666
    }
}
