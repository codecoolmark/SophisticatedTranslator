package com.codecool.sophisticatedtranslator;

import java.util.Optional;

public record Translation(String originalWord, Optional<String> translation) { }
