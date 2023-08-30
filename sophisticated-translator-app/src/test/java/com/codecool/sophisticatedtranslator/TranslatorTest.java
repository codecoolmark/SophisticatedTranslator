package com.codecool.sophisticatedtranslator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Optional;


class TranslatorTest {

    @Test
    public void testTranslate() {
        // Arrange
        var wordToTranslate = "Hello";
        var expectedTranslation = "Hallo";
        var wordPairs = List.of(new WordPair(wordToTranslate, expectedTranslation));
        var translator = new Translator(wordPairs);

        // Act
        var output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);

        // Arrange
        wordToTranslate = "Hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);

        // Arrange
        wordToTranslate = "Hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);

        // Arrange
        wordToTranslate = "Esel";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.empty(), output);

        // Arrange
        wordToTranslate = "hello";
        expectedTranslation = "Hallo";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);

        // Arrange
        wordToTranslate = "hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);

        // Arrange
        wordToTranslate = "Sand";
        expectedTranslation = "Sand";
        wordPairs = List.of(new WordPair(wordToTranslate, expectedTranslation));
        translator = new Translator(wordPairs);

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(Optional.of(expectedTranslation), output);
    }
}