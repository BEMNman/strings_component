package com.epam.strings.text.parser.impl;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends AbstractParser {
    private static final String REG_EX_SPLIT_SENTENCE = "(?<=[.!?])( )";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(string);
            String[] parts = string.trim().split(REG_EX_SPLIT_SENTENCE);

            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new TextComposite(components);
    }
}
