package com.thoughtworks.text.composition

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class ComposerTest extends Specification {

    def setup() {
        Files.deleteIfExists(Paths.get("output"))
    }

    def cleanup() {
        Lines.MAX_LINE_LENGTH = 120
    }

    def 'the max length of output lines should not greater than max line length'() {
        given:
        Lines.MAX_LINE_LENGTH = 10
        def inputSource = 'The appearance of text on your page depends on a complex interaction of processes called composition. Using the word spacing, letterspacing, glyph scaling, and hyphenation options you’ve selected, InCopy composes your type in a way that best supports the specified parameters.'

        when:
        Path output = new Composer().compose(inputSource)

        then:
        def lines = Files.readAllLines(output)
        lines*.length().every { length -> length <= Lines.MAX_LINE_LENGTH
        }
    }

    def 'the blank space at the end of the lines should less than 2'() {
        given:
        Composer composer = new Composer()

        def input = 'Spring Cloud Contract Verifier is a tool that enables Consumer Driven Contract (CDC) development of JVM-based applications.'

        when:
        Lines.MAX_LINE_LENGTH = 60
        Path output = composer.compose(input)

        then:
        List<String> allLines = Files.readAllLines(output)
        allLines.size() == 3
        allLines.get(0) == "Spring Cloud Contract Verifier is a tool that enables Consu-"
        allLines.get(1) == "mer Driven Contract (CDC) development of JVM-based applicat-"
        allLines.get(2) == "ions."
        allLines.get(0).size() == Lines.MAX_LINE_LENGTH

    }

    def 'output file should same with standard output when input file is input.txt'() {
        given:
        Lines.MAX_LINE_LENGTH = 120
        File input = new File('src/test/resources/input.txt')
        File output = new File('output')
        when:
        new Composer().compose(Paths.get(input.toURI()))

        then:
        List<String> realLines = Files.readAllLines(Paths.get(output.toURI()))

        realLines.size() == 3

        realLines[index] == value

        where:
        index | value
        0     | 'The appearance of text on your page depends on a complex interaction of processes called composition. Using the word sp-'
        1     | 'acing, letterspacing, glyph scaling, and hyphenation options you’ve selected, InCopy composes your type in a way that b-'
        2     | 'est supports the specified parameters.'
    }


    def 'should delete the first word in first line'() {
        given:
        Lines.MAX_LINE_LENGTH = 54
        def inputSource = 'The appearance of text on your page depends on a complex interaction of processes called composition. Using the word spacing, letterspacing, glyph scaling, and hyphenation options you’ve selected, InCopy composes your type in a way that best supports the specified parameters.'

        when:
        Composer composer = new Composer()
        Path output = composer.compose(inputSource)
        composer.deleteWord(0, 0)

        then:
        def lines = Files.readAllLines(output)
        lines*.length().every { length -> length <= Lines.MAX_LINE_LENGTH
        }
        lines.get(0).startsWith("appearance")
        lines.get(0).startsWith("interaction")
    }

}


