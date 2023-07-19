package com.codecool.sophisticatedtranslator;

import java.util.Arrays;

public class DictionaryParser {

    public WordPair parse(String textToParse) {
        var parts = textToParse.split("::");

        var englishPart = parts[1];
        var englishParts = englishPart.split("\\(");
        System.out.println(Arrays.toString(englishParts));
        var englishWord = englishParts[0].trim();

        var germanPart = parts[0];
        var germanParts = germanPart.split("\\{");
        var germanWord = germanParts[0].trim();
        return new WordPair(englishWord, germanWord);
    }
}
