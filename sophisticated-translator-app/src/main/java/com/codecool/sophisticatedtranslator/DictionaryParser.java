package com.codecool.sophisticatedtranslator;

import java.util.Arrays;
import java.util.stream.Stream;

public class DictionaryParser {

    public Stream<WordPair> parse(String textToParse) {
        var lines = textToParse.split("\n");
        var wordPairs = Arrays.stream(lines)
                .filter(line -> !line.startsWith("#"))
                .map(line -> parseLine(line));
        return wordPairs;
    }

    public WordPair parseLine(String textToParse) {
        var parts = textToParse.split("::");
        var splitPattern = "[\\(\\{\\|\\[/,;<]";

        var englishPart = parts[1];
        var englishParts = englishPart.split(splitPattern);
        var englishWord = englishParts[0].trim();

        var germanPart = parts[0];
        var germanParts = germanPart.split(splitPattern);
        var germanWord = germanParts[0].trim();
        return new WordPair(englishWord, germanWord);
    }
}
