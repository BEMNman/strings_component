package com.epam.strings.text.parser;

import com.epam.strings.text.creator.TokenLeafCreator;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(SentenceParser.class.getName());
    private static final String SPLIT_WORDS = "\\s+";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        String[] parts = string.trim().split(SPLIT_WORDS);
        TokenLeafCreator leafCreator = new TokenLeafCreator();

        for (String part : parts) {
            Component leaf = leafCreator.createTokenLeaf(part);
            components.add(leaf);
        }

        String lastTokenSentence = parts[parts.length-1];
        Component mark = leafCreator.createMark(lastTokenSentence);
        components.add(mark);

        logger.debug("Sentence was parsed");

        return new TextComposite(components);
    }
}

