package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(ParagraphParser.class.getName());
    private static final String SPLIT_SENTENCE = "(?<=[.!?])( )";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(string);
            String[] parts = string.trim().split(SPLIT_SENTENCE);

            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }

        logger.debug("Paragraph was parsed");

        return new TextComposite(components);
    }
}
