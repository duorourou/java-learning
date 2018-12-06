package com.github.duorourou.romannumber.led

enum LedCharacter {
    ZERO("0", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", " ", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    ONE("1", [
            [
                    " ", " ", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", " ", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", " ", " "
            ]] as List<List<String>>),
    TWO("2", [
            [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", "-", " "
            ], [
                    "|", " ", " "
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    THREE("3", [
            [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    FOUR("4", [
            [
                    " ", " ", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", " ", " "
            ]] as List<List<String>>),
    FIVE("5", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", " "
            ], [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    SIX("6", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", " "
            ], [
                    " ", "-", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    SEVEN("7", [
            [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", " ", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", " ", " "
            ]] as List<List<String>>),
    EIGHT("8", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    NIGH("9", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", "|"
            ], [
                    " ", "-", " "
            ], [
                    " ", " ", "|"
            ], [
                    " ", "-", " "
            ]] as List<List<String>>),
    ERROR("Error", [
            [
                    " ", "-", " "
            ], [
                    "|", " ", " "
            ], [
                    " ", "-", " "
            ], [
                    "|", " ", " "
            ], [
                    " ", "-", " "
            ]] as List<List<String>>);

    private String key
    private List<List<String>> value

    public LedCharacter(String key, List<List<String>> value) {
        this.key = key
        this.value = value
    }

    private static final Map<String, LedCharacter> MAPPING =
            Arrays.asList(values()).collectEntries { [it.key, it] }

    static LedCharacter of(String character) {
        return MAPPING.getOrDefault(character, ERROR)
    }

    String getKey() { this.key }

    List<List<String>> getValue() { this.value }
}
