package com.epam.strings.text.sorter;

import com.epam.strings.text.comparator.ParagraphComparator;
import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
    public Component sortParagraph(Component text) {
        ParagraphComparator comparator = new ParagraphComparator();
        List<Component> paragraphs = text.getComponents();
        List<Component> paragraphForSort = new ArrayList<>(paragraphs);
        paragraphForSort.sort(comparator);
        return new TextComposite(paragraphForSort);
    }

    public Component sortWords(Component sentence) {
        List<Component> words = sentence.getComponents();
        int amountWords = words.size();
        String endWord = words.get(amountWords-1).getValue();
        StringBuilder endSentence = new StringBuilder();


        return null;
    }

    public Component sortWordsBySymbol(Component text, char symbol) {
        return null;
    }
}
