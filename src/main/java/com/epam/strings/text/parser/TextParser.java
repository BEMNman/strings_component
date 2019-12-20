package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextParser extends AbstractParser {
    private static final String REG_EX_SPLIT_TEXT_PARAGRAPH = "\t|( ){4}";

    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        if (checkNextSuccessor()) {
            getSuccessor().parse(string);
            String[] parts = string.trim().split(REG_EX_SPLIT_TEXT_PARAGRAPH);

            for (String part : parts) {
                Component component = getSuccessor().parse(part);
                components.add(component);
            }
        }
        return new TextComposite(components);
    }
}
