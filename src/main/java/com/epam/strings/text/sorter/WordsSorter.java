package com.epam.strings.text.sorter;

import com.epam.strings.text.copier.Copier;
import com.epam.strings.text.entity.Component;

import java.util.Comparator;
import java.util.List;

abstract class WordsSorter implements Sorter {

    final Component sortWords(Component component, Comparator<Component> comparator) {

        Copier copier = new Copier();
        Component copyText = copier.copy(component);
        for (Component paragraph : copyText.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                List<Component> words = sentence.getComponents();
                Component markSentence = words.remove(words.size() - 1);
                words.sort(comparator);
                words.add(markSentence);
            }
        }
        return copyText;
    }
}
