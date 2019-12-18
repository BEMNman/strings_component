package com.epam.strings.text.parser.impl;

import com.epam.strings.text.parser.Parser;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

    public boolean checkNextSuccessor() {
       return getSuccessor() != null;
    }
}
