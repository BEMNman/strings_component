package com.epam.strings.text.copier;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.entity.TokenLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CopierTest {

    @Test
    public void testCopyShouldReturnCopyComponent(){
        TokenLeaf word = TokenLeaf.newWord("word");
        TokenLeaf mark = TokenLeaf.newMark(".");
        Component sentence = new TextComposite();
        sentence.add(word);
        sentence.add(mark);
        Component paragraph = new TextComposite();
        paragraph.add(sentence);
        Component text = new TextComposite();
        text.add(paragraph);
        String expectedTextString = text.toString();
        Copier copier = new Copier();

        Component copyText = copier.copy(text);
        String actualTextString = copyText.toString();

        Assert.assertNotEquals(copyText, text);
        Assert.assertEquals(actualTextString, expectedTextString);
    }
}