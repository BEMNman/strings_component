package com.epam.strings.text;

import com.epam.strings.text.exception.DataReaderException;
import com.epam.strings.text.factory.SorterFactory;
import com.epam.strings.text.reader.DataReader;
import com.epam.strings.text.sorter.Sorter;
import com.epam.strings.text.sorter.SorterType;

public class Main {

    private final static String PATH = "src/test/resources/text.txt";

    public static void main(String[] args) {
        SorterFactory factory = new SorterFactory();
        Sorter sorter = factory.createSorter(SorterType.WORD_BY_LENGTH);

        DataReader reader = new DataReader();
        try {
            String string = reader.read(PATH);
            System.out.println(new Director().process(string, sorter));
        } catch (DataReaderException e) {
            e.printStackTrace();
        }

    }
}
