package com.codecool.sophisticatedtranslator;

import java.util.Arrays;
import java.util.stream.Stream;

public class DictionaryParser {

    public Stream<WordPair> parse(String textToParse) {
        var lines = textToParse.split("\n");
        var wordPairs = Arrays.stream(lines).map(line -> parseLine(line));
        return wordPairs;
    }

    public WordPair parseLine(String textToParse) {
        var parts = textToParse.split("::");

        var englishPart = parts[1];
        var englishParts = englishPart.split("[\\(\\{\\|]");
        var englishWord = englishParts[0].trim();

        var germanPart = parts[0];
        var germanParts = germanPart.split("[\\(\\{\\|]");
        var germanWord = germanParts[0].trim();
        return new WordPair(englishWord, germanWord);
    }
}
