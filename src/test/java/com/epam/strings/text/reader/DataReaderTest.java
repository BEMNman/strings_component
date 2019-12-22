package com.epam.strings.text.reader;

import com.epam.strings.text.exception.DataReaderException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataReaderTest {

    private static final String FILE_NOT_EMPTY = "src/test/resources/testReaderNotEmpty.txt";
    private static final String FILE_NOT_EXIST = "src/test/resources/testReaderNotExist.txt";

    private final DataReader reader = new DataReader();

    @Test
    public void testReadShouldReturnStringWhenFileNotEmpty() throws DataReaderException {
        String expectedString = "Test file. Paragraph one. Sentence one. Sentence two." +
                "    Paragraph one. Sentence one. Sentence two." +
                "    Paragraph one. Sentence one. Sentence two." +
                "    End.";

        String actualString = reader.read(FILE_NOT_EMPTY);

        Assert.assertEquals(actualString, expectedString);
    }

    @Test(expectedExceptions = DataReaderException.class)
    public void testReadShouldThrowIOExceptionWhenFileNotExist() throws DataReaderException {
        String readString = reader.read(FILE_NOT_EXIST);
    }
}