package com.codecool.sophisticatedtranslator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Translator {

    private final List<WordPair> wordPairs;

    public Translator(List<WordPair> wordPairs) {
        this.wordPairs = wordPairs;
    }

    public String translate(String input) {
        var words = input.split(" ");

        return Arrays.stream(words)
                .map(word -> new Translation(word, translateWord(word)))
                .map(pair -> pair.translation().orElse(pair.originalWord()))
                .collect(Collectors.joining(" "));
    }

    public Optional<String> translateWord(String input) {
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
