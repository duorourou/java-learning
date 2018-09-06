package com.thoughtworks.text.composition

import spock.lang.Specification

class WordTest extends Specification {

    def 'should separate the word as 2 part with the length and hyphen' () {
        given:
        def word = new Word("Separate")

        when:
        def frontPart = word.separate(2)

        then:
        frontPart == "S-"
        word.restContent() == "eparate"
    }


    def 'should separate the word rest content as 2 part with the length and hyphen' () {
        given:
        def word = new Word("Separate")
        word.separate(2)

        when:
        def frontPart = word.separate(2)

        then:
        frontPart == "e-"
        word.restContent() == "parate"
    }
}
