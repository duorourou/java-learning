package com.thoughtworks.text.composition;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Composer {
    private List<Word> words = new ArrayList<>();
    private Line composerLine = null;

    public Path compose(Path input) throws IOException {

        return compose(Files.readAllLines(input)
                .stream()
                .reduce((s1, s2) -> String.join(" "))
                .orElse(""));
    }

    public Path compose(String input) throws IOException {

        words = lineSeparate(input);
        return compose(words);
    }

    public Path compose(List<Word> words) throws IOException {
        composerLine = Lines.build(words);
        return print();
    }

    private Path print() throws IOException {
        Path outputPath = Paths.get("output");
        if (Files.exists(outputPath)) {
            Files.deleteIfExists(outputPath);
        }
        Path output = Files.createFile(outputPath);
        Files.write(output, flat(composerLine));
        return output;
    }

    private List<Word> lineSeparate(String strings) {
        return Arrays.stream(strings.split(" "))
                .filter(str -> !str.isEmpty())
                .map(Word::new)
                .collect(toList());
    }

    public void deleteWord(int lineNumber, int wordIndexInLine) throws IOException {
        Word toDelete = null;
        var line = composerLine;
        while (line.hasNext()) {
            if (line.lineNumber == lineNumber) {
                toDelete = line.getWordAt(wordIndexInLine);
                break;
            }
            line = line.next();
        }
        words.remove(toDelete);
        words.forEach(Word::reset);
        compose(words);
    }

    private static List<String> flat(Line firstLine) {
        List<String> result = new ArrayList<>();
        var line = firstLine;
        do {
            result.add(line.content());
        } while ((line = line.next()) != null);
        return result;
    }
}
