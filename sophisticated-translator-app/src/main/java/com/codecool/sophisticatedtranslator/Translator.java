package com.codecool.sophisticatedtranslator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Translator {

    private final List<WordPair> wordPairs;

    public Translator(List<WordPair> wordPairs) {
        this.wordPairs = wordPairs;
    }

    public Optional<String> translate(String input) {
        var germanTranslations = this.wordPairs.stream()
                .filter(pair -> pair.englishWord().equalsIgnoreCase(input))
                .map(WordPair::germanWord);

        var englishTranslations = this.wordPairs.stream()
                .filter(pair -> pair.germanWord().equalsIgnoreCase(input))
                .map(WordPair::englishWord);

        return germanTranslations
                .findAny()
                .or(englishTranslations::findAny);
    }
}
