package com.epam.strings.text.reader;

import com.epam.strings.text.exception.DataReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DataReader {
    public String read(String path) throws DataReaderException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(path)))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            throw new DataReaderException(e);
        }
        return contentBuilder.toString();
    }
}
