package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import com.epam.strings.text.entity.TextComposite;
import com.epam.strings.text.entity.TokenLeaf;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TextParserTest {

    private static final String STRING_TEST_SENTENCES_TWO = "\tParagraph One. Sentence one: begin some text - end. Sentence two: begin some text - end?" +
            "\tParagraph Two. Sentence one: begin some text - end. Sentence two: begin some text - end." +
            "\tParagraph Three. Sentence one: begin some text - end. Sentence two: begin some text - end.";

    @Test
    public void testParseShouldReturnComponentWithListSizeThreeWhenInputStringContainThreeParagraphs() {
        int expectedSizeComponents = 3;
        String expectedFirstParagraph = "Paragraph One. Sentence one: begin some text - end. Sentence two: begin some text - end?";
        String expectedSecondParagraph = "Paragraph Two. Sentence one: begin some text - end. Sentence two: begin some text - end.";
        String expectedThirdParagraph = "Paragraph Three. Sentence one: begin some text - end. Sentence two: begin some text - end.";
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(Mockito.anyString()))
                .thenAnswer(invocationOnMock -> TokenLeaf.newWord((String) invocationOnMock.getArguments()[0]));
        TextParser parser = new TextParser();
        parser.setSuccessor(paragraphParser);

        Component actualComponent = parser.parse(STRING_TEST_SENTENCES_TWO);
        int actualSizeComponents = actualComponent.getComponents().size();
        List<Component> paragraphs = actualComponent.getComponents();
        String actualFirstParagraph = paragraphs.get(0).getValue();
        String actualSecondParagraph = paragraphs.get(1).getValue();
        String actualThirdParagraph = paragraphs.get(2).getValue();

        Assert.assertEquals(actualSizeComponents, expectedSizeComponents);
        Assert.assertEquals(actualFirstParagraph, expectedFirstParagraph);
        Assert.assertEquals(actualSecondParagraph, expectedSecondParagraph);
        Assert.assertEquals(actualThirdParagraph, expectedThirdParagraph);
        Mockito.verify(paragraphParser, Mockito.times(4)).parse(Mockito.anyString());
    }
}