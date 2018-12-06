package com.github.duorourou.romannumber.led

import spock.lang.Specification

class LedCharacterTest extends Specification {

    def "find a led character"() {
        expect:
        LedCharacter.of(number) == led
        where:
        number  | led
        "0"     | LedCharacter.ZERO
        "1"     | LedCharacter.ONE
        "2"     | LedCharacter.TWO
        "3"     | LedCharacter.THREE
        "4"     | LedCharacter.FOUR
        "5"     | LedCharacter.FIVE
        "6"     | LedCharacter.SIX
        "7"     | LedCharacter.SEVEN
        "8"     | LedCharacter.EIGHT
        "9"     | LedCharacter.NIGH
        "ERROR" | LedCharacter.ERROR
    }
}
