package com.epam.strings.text.sorter;

import com.epam.strings.text.entity.Component;

import java.util.Comparator;

public class WordSorterByLength extends WordsSorter {

    @Override
    public Component sort(Component component) {
        Comparator<Component> comparator = Comparator.comparing(x -> x.getValue().length());
        return sortWords(component, comparator);
    }
}
