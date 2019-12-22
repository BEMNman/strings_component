package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(TextParser.class.getName());
    private static final String SPLIT_TEXT_PARAGRAPH = "\t|( ){4}";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(string);
            String[] parts = string.trim().split(SPLIT_TEXT_PARAGRAPH);

            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }

        logger.debug("Text was parsed");

        return new TextComposite(components);
    }
}
