package com.epam.strings.text.parser;

import com.epam.strings.text.creator.TokenLeafCreator;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String SPLIT_WORDS = "\\s+";



    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        String[] parts = string.trim().split(SPLIT_WORDS);
        TokenLeafCreator leafCreator = new TokenLeafCreator();

        for (String part : parts) {
            Component leaf = leafCreator.createWordOrExpression(part);
            components.add(leaf);
        }

        String lastTokenSentence = parts[parts.length-1];
        components.add(leafCreator.createMark(lastTokenSentence));
        return new TextComposite(components);
    }
}

