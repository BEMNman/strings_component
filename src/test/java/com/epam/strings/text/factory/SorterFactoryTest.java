package com.epam.strings.text.factory;

import com.epam.strings.text.sorter.WordSorterByLength;
import com.epam.strings.text.sorter.ParagraphSorter;
import com.epam.strings.text.sorter.Sorter;
import com.epam.strings.text.sorter.SorterType;
import com.epam.strings.text.sorter.WordSorterByAmountSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SorterFactoryTest {

    private final SorterFactory factory = new SorterFactory();

    @Test
    public void testCreateSorterShouldReturnParagraphSorterWhenTypePARAGRAPH() {
        Sorter actualSorter = factory.createSorter(SorterType.PARAGRAPH);

        Assert.assertEquals(actualSorter.getClass(), ParagraphSorter.class);
    }

    @Test
    public void testCreateSorterShouldReturnPWordSorterByAmountSymbolWhenTypeWordByAmountSymbolSpace() {
        Sorter actualSorter = factory.createSorter(SorterType.WORD_BY_AMOUNT_SYMBOL);

        Assert.assertEquals(actualSorter.getClass(), WordSorterByAmountSymbol.class);
    }

    @Test
    public void testCreateSorterShouldReturnPWordSorterByLengthWhenTypeWordByLength() {
        Sorter actualSorter = factory.createSorter(SorterType.WORD_BY_LENGTH);

        Assert.assertEquals(actualSorter.getClass(), WordSorterByLength.class);
    }

    @Test
    public void testCreateSorterBySymbolShouldReturnPWordSorterByAmountSymbolWhenTypeWordByAmountSymbolA() {
        Sorter actualSorter = factory.createSorter(SorterType.WORD_BY_AMOUNT_SYMBOL);

        Assert.assertEquals(actualSorter.getClass(), WordSorterByAmountSymbol.class);
    }
}