package com.github.duorourou.romannumber.presenter

import com.github.duorourou.romannumber.led.LedCharacter
import com.github.duorourou.romannumber.zoom.Zoom

import static java.util.stream.Collectors.toList

class Presenter {

    def ledReduce = {
        result, it ->
            combine(result, it.getValue())

    }

    def contact = {
        result -> result.stream().map { list -> list.inject { all, it -> all + it } }.collect(toList())
    }

    def combine = {
        one, another ->
            if (one == null) {
                return another
            }
            for (int index = 0; index < one.size(); index++) {
                one.get(index).addAll(another.get(index))
            }
            one
    }

    void present(List<LedCharacter> leds) {
        List<List<String>> result = leds.inject(null, ledReduce)
        List<String> reduce = contact(new Zoom().hZoom(result, 2))
        ledPrint(reduce)
    }

    private void ledPrint(List<String> ledResult) {
        ledResult.forEach {
            line -> println(line)
        }
    }


}
