package com.epam.strings.text.sorter;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.entity.TokenLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordSorterByAmountSymbolTest {

    @Test
    public void testSortShouldReturnSortedTextByAmountSymbolWhenSymbolLittleT() {
        char symbol = 't';
        Component leafOne = TokenLeaf.newWord("one-word");
        Component leafTwo = TokenLeaf.newWord("two-word");
        Component leafThree = TokenLeaf.newWord("three-word");
        Component leafFour = TokenLeaf.newWord("four-word");
        Component leafMark = TokenLeaf.newWord(".");
        Component sentence = new TextComposite();
        sentence.add(leafOne);
        sentence.add(leafTwo);
        sentence.add(leafThree);
        sentence.add(leafFour);
        sentence.add(leafMark);
        Component paragraph = new TextComposite();
        paragraph.add(sentence);
        Component text = new TextComposite();
        text.add(paragraph);

        Component expectedSentence = new TextComposite();
        expectedSentence.add(leafFour);
        expectedSentence.add(leafOne);
        expectedSentence.add(leafThree);
        expectedSentence.add(leafTwo);
        expectedSentence.add(leafMark);
        Component expectedParagraph = new TextComposite();
        expectedParagraph.add(expectedSentence);
        Component expectedSortedText = new TextComposite();
        expectedSortedText.add(expectedParagraph);
        WordSorterByAmountSymbol sorter = new WordSorterByAmountSymbol(symbol);

        Component actualSortedText = sorter.sort(text);

        Assert.assertEquals(actualSortedText.toString(), expectedSortedText.toString());
    }
}