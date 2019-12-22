package com.epam.strings.text.sorter;

import com.epam.strings.text.entity.Component;

import java.util.Comparator;

public class WordSorterByAmountSymbol extends WordsSorter {

    private char symbol;

    public WordSorterByAmountSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public Component sort(Component component) {
        Comparator<Component> comparatorAmountSymbol = Comparator
                .comparing(x->x.getValue().chars().filter(ch->ch==symbol).count());
        Comparator<Component> comparatorAlphabet = Comparator.comparing(Component::getValue);
        Comparator<Component> comparator = comparatorAmountSymbol.thenComparing(comparatorAlphabet);

        return sortWords(component, comparator);
    }
}
