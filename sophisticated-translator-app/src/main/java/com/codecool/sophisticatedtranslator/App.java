package com.codecool.sophisticatedtranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        var dictionaryString = Files.readString(Path.of("..", "de-en.txt"));
        var dictionaryParser = new DictionaryParser();
        var wordPairs = dictionaryParser.parse(dictionaryString).collect(Collectors.toList());

        var translator = new Translator(wordPairs);
        var prompt = new Prompt(translator);
        prompt.start();
    }
}
