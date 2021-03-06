package com.epam.strings.text.parser;

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
