package com.thoughtworks.text.composition;

public class Word {
    public final String content;
    private String restContent;

    public Word(String content) {
        this.content = content;
        this.restContent = content;
    }

    public String restContent() {
        return restContent;
    }

    public String separate(int length) {
        String frontPart = this.restContent.substring(0, length - 1) + "-";
        this.restContent = this.restContent.substring(length - 1);
        return frontPart;
    }

    public void reset () {
        this.restContent = content;
    }

}
