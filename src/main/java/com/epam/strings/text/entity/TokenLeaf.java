package com.epam.strings.text.entity;

import java.io.Serializable;
import java.util.List;

public class TokenLeaf implements Component, Serializable {
    private String value;
    private TypeLeaf type;

    private TokenLeaf(String value, TypeLeaf type) {
        this.value = value;
        this.type = type;
    }

    public static TokenLeaf newWord(String value) {
        return new TokenLeaf(value, TypeLeaf.LITERAL);
    }

    public static TokenLeaf newExpression(String value) {
        return new TokenLeaf(value, TypeLeaf.EXPRESSION);
    }

    public static TokenLeaf newMark(String value) {
        return new TokenLeaf(value, TypeLeaf.MARK);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Component> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getValue() {
        return value;
    }
}
