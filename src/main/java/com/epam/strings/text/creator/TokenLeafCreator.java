package com.epam.strings.text.creator;

import com.epam.strings.text.expression.calculator.ExpressionCalculator;
import com.epam.strings.text.entity.TokenLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TokenLeafCreator {

    private static final Logger logger = LogManager.getLogger(TokenLeafCreator.class.getName());
    private static final String FIRST_SYMBOL_EXPRESSION = "[";
    private static final String FINAL_SYMBOL_EXPRESSION = "]";
    private static final String SENTENCE_MARK = "[.!?]";

    public TokenLeaf createTokenLeaf(String string) {
        String wordWithoutMark = spotWord(string);
        TokenLeaf leaf;
        if (isExpression(wordWithoutMark)) {
            ExpressionCalculator calculator = new ExpressionCalculator(wordWithoutMark);
            String value = calculator.calculate().toString();
            leaf = TokenLeaf.newExpression(value);
        } else {
            leaf = TokenLeaf.newWord(wordWithoutMark);
        }

        logger.debug("Leaf " + leaf + " was created");

        return leaf;
    }

    public TokenLeaf createMark(String sentence) {
        TokenLeaf component;
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
        return string.split(SENTENCE_MARK)[0];
    }
}
