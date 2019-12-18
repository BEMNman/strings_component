package com.epam.strings.text.entity.impl;

import com.epam.strings.text.entity.Component;

import java.util.List;

public class MarkLeaf implements Component {
    private String value;

    public MarkLeaf(String value) {
        this.value = value;
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
