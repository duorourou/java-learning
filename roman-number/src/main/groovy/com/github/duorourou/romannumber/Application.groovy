package com.github.duorourou.romannumber

import com.github.duorourou.romannumber.led.LedCharacter
import com.github.duorourou.romannumber.parser.RomanDigits
import com.github.duorourou.romannumber.presenter.Presenter

import static java.util.stream.Collectors.toList

class Application {
    static void main(String[] args) {
        BigInteger arabic = RomanDigits.parse("CXXIII")

        List<LedCharacter> res = Arrays.stream(arabic.toString().toCharArray())
                .map {
            ch -> LedCharacter.of(ch.toString())
        }.collect(toList())

        new Presenter().present(res)
    }
}
