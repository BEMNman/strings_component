package com.epam.strings.text.creator;

import com.epam.strings.text.calculator.ExpressionCalculator;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TokenLeaf;
import com.epam.strings.text.exception.ArithmeticOperationException;

public class TokenLeafCreator {

    private static final String FIRST_SYMBOL_EXPRESSION = "[";
    private static final String FINAL_SYMBOL_EXPRESSION = "]";
    private static final String SENTENCE_MARK = "[.!?]";

    public Component createWordOrExpression(String string) {
        String wordWithoutMark = spotWord(string);
        Component leaf = null;
        if (isExpression(wordWithoutMark)) {
            ExpressionCalculator calculator = new ExpressionCalculator();
            try {
                String value = calculator.calculate(wordWithoutMark);
                leaf = TokenLeaf.newExpression(value);
            } catch (ArithmeticOperationException e) {
//                    e.printStackTrace();                      replace with logger
            }
        } else {
            leaf = TokenLeaf.newWord(wordWithoutMark);
        }
        return leaf;
    }

    public Component createMark(String sentence) {
        Component component = null;
        if (sentence.endsWith("...")) {
            component = TokenLeaf.newMark("...");
        } else if (sentence.endsWith(".")) {
            component = TokenLeaf.newMark(".");
        } else if (sentence.endsWith("!")) {
            component = TokenLeaf.newMark("!");
        } else {
            component = TokenLeaf.newMark("?");
        }
        return component;
    }

    private boolean isExpression(String string) {
        return string.startsWith(FIRST_SYMBOL_EXPRESSION)
                && string.endsWith(FINAL_SYMBOL_EXPRESSION);
    }

    private String spotWord(String string) {
        String word = string.split(SENTENCE_MARK)[0];
        return word;
    }
}
