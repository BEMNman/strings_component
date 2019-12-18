package com.epam.strings.text;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.exception.DataReaderException;
import com.epam.strings.text.parser.impl.ParagraphParser;
import com.epam.strings.text.parser.impl.SentenceParser;
import com.epam.strings.text.parser.impl.TextParser;
import com.epam.strings.text.reader.DataReader;
import com.epam.strings.text.sorter.Sorter;

public class Director {
    public void start() throws DataReaderException {
        String string = new DataReader().read("src/test/resources/text.txt");
        System.out.println(string);

        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();

        paragraphParser.setSuccessor(sentenceParser);
        textParser.setSuccessor(paragraphParser);

        Component component = textParser.parse(string);
        System.out.println(component);

        Sorter sorter = new Sorter();
        Component componentSortParagraphs = sorter.sortParagraph(component);
        System.out.println(component);
    }
}
