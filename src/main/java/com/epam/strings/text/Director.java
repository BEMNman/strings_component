package com.epam.strings.text;

import com.epam.strings.text.copier.Copier;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.exception.DataReaderException;
import com.epam.strings.text.parser.ParagraphParser;
import com.epam.strings.text.parser.SentenceParser;
import com.epam.strings.text.parser.TextParser;
import com.epam.strings.text.reader.DataReader;
import com.epam.strings.text.sorter.Sorter;

import java.io.IOException;

public class Director {

    public static final String PATH_INPUT_FILE = "src/test/resources/text.txt";

    public void process() throws DataReaderException {
        String string = null;
        try {
            string = new DataReader().read(PATH_INPUT_FILE);
        } catch (IOException e) {
            throw new DataReaderException(e);
        }
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
        System.out.println(componentSortParagraphs);

        Component componentSortWords = sorter.sortWordsByLength(component);
        System.out.println(componentSortWords);

        Copier<Component> copier = new Copier<>();
        try {
            Component copy = copier.copy(component);
            copy.add(new TextComposite(null));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
