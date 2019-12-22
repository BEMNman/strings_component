package com.epam.strings.text;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.parser.ParagraphParser;
import com.epam.strings.text.parser.SentenceParser;
import com.epam.strings.text.parser.TextParser;
import com.epam.strings.text.sorter.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {

    private static final Logger logger = LogManager.getLogger(Director.class.getName());

    public String process(String text, Sorter sorter) {
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();

        paragraphParser.setSuccessor(sentenceParser);
        textParser.setSuccessor(paragraphParser);

        Component component = textParser.parse(text);
        Component sortedComponent = sorter.sort(component);

        logger.debug(text + " was sorted!");

        return sortedComponent.toString();
    }
}
