package com.epam.strings.text.expression.terminal;

import com.epam.strings.text.expression.context.Context;

public class TerminalOperationMinus implements MathOperation {

    @Override
    public void interpret(Context c) {
        c.pushValue((c.popValue() - c.popValue()));
    }
}
