package com.epam.strings.text.entity;

import java.util.List;

public interface Component{
    void add(Component component);

    List<Component> getComponents();

    String getValue();
}
