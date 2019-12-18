package com.epam.strings.text.parser.impl;

import com.epam.strings.text.calculator.ExpressionCalculator;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.impl.MarkLeaf;
import com.epam.strings.text.entity.impl.TextComposite;
import com.epam.strings.text.entity.impl.TypeUnitLeaf;
import com.epam.strings.text.entity.impl.UnitLeaf;
import com.epam.strings.text.exception.ArithmeticOperationException;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String REG_EX_SPLIT_WORDS = " ";
    private static final String REG_EX_SPLIT_FIRST_SYMBOL_EXPRESSION = "[";
    private static final String REG_EX_SPLIT_FINAL_SYMBOL_EXPRESSION = "]";
    private static final String REG_EX_SPLIT_SENTENCE_MARK = "[.!?]";


    @Override
    public Component parse(String string) {
        List<Component> components = new ArrayList<>();
        String[] parts = string.trim().split(REG_EX_SPLIT_WORDS);

        for (String part : parts) {
            String wordWithoutMark = spotWord(part);
            Component leaf = null;

            if (isExpression(wordWithoutMark)) {
                ExpressionCalculator calculator = new ExpressionCalculator();
                String value = null;
                try {
                    value = calculator.calculate(wordWithoutMark);
                } catch (ArithmeticOperationException e) {
//                    e.printStackTrace();                      replace with logger
                }
                leaf = new UnitLeaf(TypeUnitLeaf.EXPRESSION, value);
            } else {
                leaf = new UnitLeaf(TypeUnitLeaf.LITERAL, wordWithoutMark);
            }
            components.add(leaf);
        }

        String lastUnitSentence = parts[parts.length-1];
        components.add(spotSentenceMark(lastUnitSentence));
        return new TextComposite(components);
    }

    private boolean isExpression(String string) {
        return string.startsWith(REG_EX_SPLIT_FIRST_SYMBOL_EXPRESSION)
                && string.endsWith(REG_EX_SPLIT_FINAL_SYMBOL_EXPRESSION);
    }

    private Component spotSentenceMark(String sentence) {
        Component component = null;
        if (sentence.endsWith("...")) {
            component = new MarkLeaf("...");
        } else if (sentence.endsWith(".")) {
            component = new MarkLeaf(".");
        } else if (sentence.endsWith("!")) {
            component = new MarkLeaf("!");
        } else {
            component = new MarkLeaf("?");
        }
        return component;
    }

    private String spotWord(String string) {
        String bodySentence = string.split(REG_EX_SPLIT_SENTENCE_MARK)[0];
        return bodySentence;
    }
}

