package com.thoughtworks.text.composition;

import java.util.List;

public class Lines {

    public static int MAX_LINE_LENGTH = 120;

    public static Line build(List<Word> words) {
        Line firstLine = new Line(0);
        Line line = firstLine;
        for (var index = 0; index < words.size(); index++) {
            line = line.appendWord(words.get(index));
        }
        return firstLine;
    }




}
