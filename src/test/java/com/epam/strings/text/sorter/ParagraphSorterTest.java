package com.epam.strings.text.sorter;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.entity.TokenLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ParagraphSorterTest {

    @Test
    public void testSortShouldReturnSortedCopyComponentByParagraphs() {
        Component leafOne = TokenLeaf.newWord("one-word");
        Component leafTwo = TokenLeaf.newWord("two-word");
        Component leafThree = TokenLeaf.newWord("three-word");
        Component leafFour = TokenLeaf.newWord("four-word");
        Component sentenceOne = new TextComposite(Arrays.asList(leafOne, leafTwo, leafThree, leafFour));
        Component sentenceTwo = new TextComposite(Arrays.asList(leafOne, leafTwo));
        Component sentenceThree = new TextComposite(Arrays.asList(leafFour, leafTwo, leafFour));
        Component paragraphOne = new TextComposite(Arrays.asList(sentenceOne, sentenceThree));
        Component paragraphTwo = new TextComposite(Arrays.asList(sentenceOne, sentenceThree, sentenceTwo));
        Component paragraphThree = new TextComposite(Arrays.asList(sentenceTwo));
        Component text = new TextComposite(Arrays.asList(paragraphOne, paragraphTwo, paragraphThree));
        Component expectedText =new TextComposite(Arrays.asList(paragraphThree, paragraphOne, paragraphTwo));
        ParagraphSorter sorter = new ParagraphSorter();

        Component actualText = sorter.sort(text);

        Assert.assertEquals(actualText.toString(), expectedText.toString());
    }
}