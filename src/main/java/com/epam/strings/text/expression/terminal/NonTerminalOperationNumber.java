package com.epam.strings.text.expression.terminal;

import com.epam.strings.text.expression.context.Context;

public class NonTerminalOperationNumber implements MathOperation {

    private int number;

    public NonTerminalOperationNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
