package com.codecool.sophisticatedtranslator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DictionaryParserTest {

    @Test
    public void testSimpleLine() {
        var testLine = "Aalfang {m} :: eel fishing";
        var parser = new DictionaryParser();
        var output = parser.parseLine(testLine);
        var expectedOutput = new WordPair("eel fishing", "Aalfang");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "A-bewertet {adj} :: A-weighted";
        output = parser.parseLine(testLine);
        expectedOutput = new WordPair("A-weighted", "A-bewertet");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "Abazissus {m} [arch.] :: colarin";
        output = parser.parseLine(testLine);
        expectedOutput = new WordPair("colarin", "Abazissus");
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    public void testCompoundLines() {
        // Arrange
        var testLine = "Abandonist {m} (Versicherungswesen) | Abandonisten {pl} :: abandoner (insurance business) | abandoners";
        var parser = new DictionaryParser();

        // Act
        var output = parser.parseLine(testLine);

        // Assert
        var expectedOutput = new WordPair("abandoner", "Abandonist");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "Abandonist {m} (Versicherungswesen) | Abandonisten {pl} :: abandoner (insurance business) | abandoners";
        output = parser.parseLine(testLine);
        expectedOutput = new WordPair("abandoner", "Abandonist");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Aachener {adj} | der Aachener Dom | Aachener Printen [cook.] :: Aachen | the Aachen Cathedral | hard ginger bread from Aachen";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair( "Aachen", "Aachener");
        Assertions.assertEquals(expectedOutput, output);

        testLine = "Diethylsulfat {n} [chem.] :: diethyl sulphate [Br.]; diethyl sulfate [Am.]";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair("diethyl sulphate", "Diethylsulfat");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Trichlorbenzole {pl} [chem.] :: trichlorobenzenes /TCB/";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair("trichlorobenzenes", "Trichlorbenzole");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Pyrrolidon, N-Octyl- {n} [chem.] :: pyrrolidone, N-octyl-";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair("pyrrolidone", "Pyrrolidon");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Acrylsäureethylester {n}; Ethylacrylat {n} [chem.] :: ethyl acrylate; acrylic acid ethyl ester";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair("ethyl acrylate", "Acrylsäureethylester");

        Assertions.assertEquals(expectedOutput, output);

        testLine = "Chlorpromazin {n} [chem.] :: chlorpromazine <Thorazine>";
        output = parser.parseLine(testLine);

        expectedOutput = new WordPair("chlorpromazine", "Chlorpromazin");

        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    public void testMultipleLines() {
        // Arrange
        var testLines = "Aachener {adj} | der Aachener Dom | Aachener Printen [cook.] :: Aachen | the Aachen Cathedral | hard ginger bread from Aachen\n" +
                "Aachener {m}; Aachenerin {f} (Bewohner Aachens) :: Aachen resident\n" +
                "Aalbestand {m} | Aalbestände {pl} :: eel stock | eel stocks\n" +
                "Aalspieß {m} | Aalspieße {pl} :: eel spear | eel spears";
        var parser = new DictionaryParser();

        // Act
        var output = parser.parse(testLines).collect(Collectors.toList());

        // Assert
        var expectedOutput = List.of(new WordPair("Aachen", "Aachener"),
                new WordPair("Aachen resident", "Aachener"),
                new WordPair("eel stock", "Aalbestand"),
                new WordPair("eel spear", "Aalspieß"));
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    public void testLineComments() {
        // Arrange

        var testLines = "# this is a line comment\n" +
                "Aachener {adj} | der Aachener Dom | Aachener Printen [cook.] :: Aachen | the Aachen Cathedral | hard ginger bread from Aachen\n";
        var parser = new DictionaryParser();

        // Act
        var output = parser.parse(testLines).collect(Collectors.toList());

        var expectedResult = List.of(new WordPair("Aachen", "Aachener"));

        Assertions.assertEquals(expectedResult, output);
    }

}
