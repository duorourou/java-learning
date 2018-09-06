package com.thoughtworks.text.composition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.thoughtworks.text.composition.Lines.MAX_LINE_LENGTH;

public class Line implements Iterator<Line> {
    static final String WORD_CONNECTOR = " ";

    public final int lineNumber;
    private List<Word> words = new ArrayList<>();
    private final StringBuffer contents = new StringBuffer();
    private Line nextLine = null;

    public Line(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    private void appendContent(String content) {
        contents.append(contents.length() > 0 ? WORD_CONNECTOR : "")
                .append(content);
    }

    @Override
    public boolean hasNext() {
        return nextLine != null;
    }

    @Override
    public Line next() {
        return nextLine;
    }

    public Line withParent(Line parent) {
        parent.nextLine = this;
        return this;
    }

    public Line appendWord(Word word) {

        if (restLength() >= word.restContent().length()) {
            this.words.add(word);
            appendContent(word.restContent());
        } else if (restLength() <= 1) {
            var line = new Line(this.lineNumber + 1).withParent(this);
            line.appendWord(word);
            return line;
        } else {
            this.words.add(word);
            appendContent(word.separate(restLength()));
            var line = new Line(this.lineNumber + 1).withParent(this);
            line.appendWord(word);
            return line;
        }
        return this;
    }

    private int restLength() {
        return MAX_LINE_LENGTH - contents.length() - WORD_CONNECTOR.length();
    }

    public String content() {
        return contents.toString();
    }

    public Word getWordAt(int wordIndexInLine) {
        return words.get(wordIndexInLine);
    }
}
