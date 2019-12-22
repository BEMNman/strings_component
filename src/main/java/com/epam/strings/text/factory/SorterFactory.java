package com.epam.strings.text.factory;

import com.epam.strings.text.sorter.*;

public class SorterFactory {

    public Sorter createSorter(SorterType type) {
        Sorter sorter = null;

        switch (type) {
            case PARAGRAPH:
                sorter = new ParagraphSorter();
                break;
            case WORD_BY_LENGTH:
                sorter = new WordSorterByLength();
                break;
            case WORD_BY_AMOUNT_SYMBOL:
                sorter = new WordSorterByAmountSymbol(' ');
        }
        return sorter;
    }
}
