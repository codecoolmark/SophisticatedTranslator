package com.codecool.sophisticatedtranslator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DictionaryParserTest {

    @Test
    public void testSimpleLine() {
        var testLine = "Aalfang {m} :: eel fishing";
        var parser = new DictionaryParser();
        var output = parser.parse(testLine);
        var expectedOutput = new WordPair("eel fishing", "Aalfang");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "A-bewertet {adj} :: A-weighted";
        output = parser.parse(testLine);
        expectedOutput = new WordPair("A-weighted", "A-bewertet");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "Abazissus {m} [arch.] :: colarin";
        output = parser.parse(testLine);
        expectedOutput = new WordPair("colarin", "Abazissus");
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    public void testCompoundLines() {
        var testLine = "Abandonist {m} (Versicherungswesen) | Abandonisten {pl} :: abandoner (insurance business) | abandoners";
        var parser = new DictionaryParser();
        var output = parser.parse(testLine);
        var expectedOutput = new WordPair("abandoner", "Abandonist");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Abandonist {m} (Versicherungswesen) | Abandonisten {pl} :: abandoner (insurance business) | abandoners";
        output = parser.parse(testLine);
        expectedOutput = new WordPair("abandoner", "Abandonist");

        Assertions.assertEquals(expectedOutput, output);
    }
}
