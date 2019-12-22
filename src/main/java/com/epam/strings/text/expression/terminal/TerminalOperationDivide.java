package com.epam.strings.text.expression.terminal;

import com.epam.strings.text.expression.context.Context;

public class TerminalOperationDivide implements MathOperation {

    @Override
    public void interpret(Context c) {
        c.pushValue((c.popValue() / c.popValue()));
    }
}
