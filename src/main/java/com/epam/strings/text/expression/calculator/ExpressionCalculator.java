package com.epam.strings.text.expression.calculator;

import com.epam.strings.text.expression.context.Context;
import com.epam.strings.text.expression.terminal.MathOperation;
import com.epam.strings.text.expression.terminal.NonTerminalOperationNumber;
import com.epam.strings.text.expression.terminal.TerminalOperationDivide;
import com.epam.strings.text.expression.terminal.TerminalOperationMinus;
import com.epam.strings.text.expression.terminal.TerminalOperationMultiply;
import com.epam.strings.text.expression.terminal.TerminalOperationPlus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ExpressionCalculator {

    private static final Logger logger = LogManager.getLogger(ExpressionCalculator.class.getName());

    private final ArrayList<MathOperation> expressions = new ArrayList<>();

    public ExpressionCalculator(String expression) {
        parse(expression);
    }

    public Integer calculate() {
        Context context = new Context();
        expressions.forEach(exp -> exp.interpret(context));
        Integer result = context.popValue();

        logger.debug("Expression was calculated: " + result);

        return result;
    }

    private void parse(String expression) {
        String tempExpression = expression.substring(1, expression.length()-1);
        for (char currentChar : tempExpression.toCharArray()) {
            switch (currentChar) {
                case '+':
                    expressions.add(new TerminalOperationPlus());
                    break;
                case '-':
                    expressions.add(new TerminalOperationMinus());
                    break;
                case '*':
                    expressions.add(new TerminalOperationMultiply());
                    break;
                case '/':
                    expressions.add(new TerminalOperationDivide());
                    break;
                default:
                    if(Character.isDigit(currentChar)) {
                        expressions.add(new NonTerminalOperationNumber(Character.digit(currentChar, 10)));
                    }
            }
        }
    }
}
