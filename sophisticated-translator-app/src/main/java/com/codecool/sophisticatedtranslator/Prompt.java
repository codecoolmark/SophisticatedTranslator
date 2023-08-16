package com.codecool.sophisticatedtranslator;

import java.util.Scanner;

public class Prompt {

    private final Translator translator;

    public Prompt(Translator translator) {
        this.translator = translator;
    }

    public void start() {
        var scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            var line = scanner.nextLine();
            if (line.equals("\\q")) {
                break;
            }

            var result = this.translator.translate(line);
            System.out.println(result);
        }
    }
}
