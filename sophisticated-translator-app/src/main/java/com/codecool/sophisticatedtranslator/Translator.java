package com.codecool.sophisticatedtranslator;

import java.util.List;

public class Translator {

    private final List<WordPair> wordPairs;

    public Translator(List<WordPair> wordPairs) {
        this.wordPairs = wordPairs;
    }

    public String translate(String input) {
        return input;
    }
}
