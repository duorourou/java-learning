package com.thoughtworks.text.composition

import spock.lang.Specification

class LineTest extends Specification {
    def "should add the firstWord when line is empty"() {
        given:
        def line = new Line(0)
        def word = new Word("This")
        when:
        line.appendWord(word)
        then:
        line.lineNumber == 0
        line.next() == null
        line.content() == "This"
    }

    def "should add the whole word when line is not empty and the length of this word less than the rest size"() {
        given:
        def line = new Line(0)
        def word = new Word("This")
        line.appendWord(word)
        when:
        def anotherWord = new Word("is")
        line.appendWord(anotherWord)
        then:
        line.lineNumber == 0
        line.next() == null
        line.content() == "This is"
    }

    def "should not add the word when the length of the word is greater than 1 the rest size of the line is less than 2"() {
        given:
        def line = new Line(0)
        def word = new Word(existingContent)
        Lines.MAX_LINE_LENGTH = MAX_LENGTH
        line.appendWord(word)

        when:
        def anotherWord = new Word(newContent)
        line.appendWord(anotherWord)

        then:
        line.content() == existingContent
        line.next() != null

        where:
        MAX_LENGTH | existingContent | newContent
        5          | "When"          | "a"
        5          | "This"          | "is"
        6          | "This"          | "is"
    }

    def "should add the word to the new line when the length of the word is greater than 1 the rest size of the line is less than 2"() {
        given:
        def line = new Line(0)
        def word = new Word(existingContent)
        Lines.MAX_LINE_LENGTH = MAX_LENGTH
        line.appendWord(word)

        when:
        def anotherWord = new Word(newContent)
        line.appendWord(anotherWord)

        then:
        line.next() != null
        line.next().content() == newContent

        where:
        MAX_LENGTH | existingContent | newContent
        5          | "When"          | "a"
        5          | "This"          | "is"
        6          | "This"          | "is"
    }

    def "should add part of the word and the others in a new line"() {
        given:
        def line = new Line(0)
        def word = new Word(existingContent)
        Lines.MAX_LINE_LENGTH = MAX_LENGTH
        line.appendWord(word)

        when:
        def anotherWord = new Word(newContent)
        line.appendWord(anotherWord)

        then:
        line.content() == firstLineContent
        line.next() != null
        line.next().content() == secondLineContent

        where:
        MAX_LENGTH | existingContent | newContent | firstLineContent | secondLineContent
        7          | "When"          | "you"      | "When y-"        | 'ou'
        14         | "LineNumber"    | "from"     | "LineNumber fr-" | 'om'
    }
}
