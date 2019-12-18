package com.epam.strings.text.entity.impl;

import com.epam.strings.text.entity.Component;

import java.util.List;

public class TextComposite implements Component {

    private List<Component> components;

    @Override
    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public TextComposite(List<Component> components) {
        this.components = components;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public String getValue() {
        throw new UnsupportedOperationException();
    }
}
