package com.epam.strings.text.reader;

import com.epam.strings.text.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {

    private static final Logger logger = LogManager.getLogger(DataReader.class.getName());

    public String read(String path) throws DataReaderException {

        logger.debug("Start reading file: " + path);

        String readString;
        try {
            readString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new DataReaderException(e);
        }

        return readString;

    }
}
