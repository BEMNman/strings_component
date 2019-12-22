package com.epam.strings.text.sorter;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.entity.TokenLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordSorterByLengthTest {

    @Test
    public void testSortShouldReturnSortedTextByLengthWords() {
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
        expectedSentence.add(leafOne);
        expectedSentence.add(leafTwo);
        expectedSentence.add(leafFour);
        expectedSentence.add(leafThree);
        expectedSentence.add(leafMark);
        Component expectedParagraph = new TextComposite();
        expectedParagraph.add(expectedSentence);
        Component expectedText = new TextComposite();
        expectedText.add(expectedParagraph);
        WordSorterByLength sorter = new WordSorterByLength();

        Component actualText = sorter.sort(text);

        Assert.assertEquals(actualText.toString(), expectedText.toString());
    }
}