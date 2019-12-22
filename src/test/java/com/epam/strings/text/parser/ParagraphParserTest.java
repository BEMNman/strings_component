package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TokenLeaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ParagraphParserTest {

    private static final String STRING_TEST_SENTENCES_TWO = " Sentence one: begin some text - end." +
            " Sentence two: begin some text - end.";

    @Test
    public void testParseShouldReturnComponentWithListSizeTwoWhenInputStringContainsTwoSentences() {
        int expectedSizeComponents = 2;
        String expectedFirstSentence = " Sentence one: begin some text - end.";
        String expectedSecondSentence = " Sentence two: begin some text - end.";
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(Mockito.anyString()))
                .thenAnswer(invocationOnMock -> TokenLeaf.newWord((String) invocationOnMock.getArguments()[0]));
        ParagraphParser parser = new ParagraphParser();
        parser.setSuccessor(sentenceParser);

        Component actualComponent = parser.parse(STRING_TEST_SENTENCES_TWO);
        List<Component> sentences = actualComponent.getComponents();
        int actualSizeComponents = sentences.size();
        String actualFirstSentence = sentences.get(0).toString();
        String actualSecondSentence = sentences.get(1).toString();

        Assert.assertEquals(actualSizeComponents, expectedSizeComponents);
        Assert.assertEquals(actualFirstSentence, expectedFirstSentence);
        Assert.assertEquals(actualSecondSentence, expectedSecondSentence);
        Mockito.verify(sentenceParser, Mockito.times(3)).parse(Mockito.anyString());
    }
}