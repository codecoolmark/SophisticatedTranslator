package com.codecool.sophisticatedtranslator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TranslatorTest {

    @Test
    public void testTranslateOneWord() {
        // Arrange
        var wordToTranslate = "Hello";
        var expectedTranslation = "Hallo";
        var wordPairs = List.of(new WordPair(wordToTranslate, expectedTranslation));
        var translator = new Translator(wordPairs);

        // Act
        var output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);

        // Arrange
        wordToTranslate = "Hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);

        // Arrange
        wordToTranslate = "Hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);

        // Arrange
        wordToTranslate = "Esel";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(wordToTranslate, output);

        // Arrange
        wordToTranslate = "hello";
        expectedTranslation = "Hallo";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);

        // Arrange
        wordToTranslate = "hallo";
        expectedTranslation = "Hello";

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);

        // Arrange
        wordToTranslate = "Sand";
        expectedTranslation = "Sand";
        wordPairs = List.of(new WordPair(wordToTranslate, expectedTranslation));
        translator = new Translator(wordPairs);

        // Act
        output = translator.translate(wordToTranslate);

        // Assert
        Assertions.assertEquals(expectedTranslation, output);
    }

    @Test
    public void testTranslateMultipleWords() {
        var hello = new WordPair("hello", "hallo");
        var world = new WordPair("world", "Welt");

        var wordPairs = List.of(hello, world);

        var translator = new Translator(wordPairs);

        var input = "hello world";
        var expectedOutput = "hallo Welt";

        var output = translator.translate(input);

        Assertions.assertEquals(expectedOutput, output);

        input = "hi world";
        expectedOutput = "hi Welt";

        output = translator.translate(input);

        Assertions.assertEquals(expectedOutput, output);
    }
}