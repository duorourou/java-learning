package com.github.duorourou.romannumber.zoom

class Zoom {

    List<List<String>> hZoom(List<List<String>> origin, int size) {
        for (int index = 0; index < origin.size(); index++) {
            for (int repeat = 0; repeat < size - 1; repeat++) {
                origin.get(index).add(2 + repeat, origin.get(index).get(1))
            }
        }
        return origin
    }

    List<List<String>> vZoom(List<List<String>> origin, int size) {

    }
}