package com.codecool.sophisticatedtranslator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        var dictionaryString = Files.readString(Path.of("..", "de-en.txt"));
        var dictionaryParser = new DictionaryParser();
        var wordPairs = dictionaryParser.parse(dictionaryString);
        System.out.println(wordPairs.count());
    }
}
