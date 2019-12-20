package com.epam.strings.text.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {
    public String read(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

    }
}
