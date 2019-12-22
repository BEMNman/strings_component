package com.epam.strings.text.parser;

import com.epam.strings.text.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SentenceParserTest {

    private static final String STRING_TEST_WORDS_SEVEN_ONE_MARK = "Sentence one.";

    @Test
    public void testParseShouldReturnComponentWithListSizeThreeWhenInputStringContainSevenWordsOneMark() {
        int expectedSizeComponents = 3;
        String expectedFistWord = "Sentence";
        String expectedSecondWord = "one";
        String expectedThirdWord = ".";

        SentenceParser parser = new SentenceParser();
        Component actualComponent = parser.parse(STRING_TEST_WORDS_SEVEN_ONE_MARK);
        int actualSizeComponents = actualComponent.getComponents().size();
        String actualFistWord = "Sentence";
        String actualSecondWord = "one";
        String actualThirdWord = ".";

        Assert.assertEquals(actualSizeComponents, expectedSizeComponents);
        Assert.assertEquals(actualFistWord, expectedFistWord);
        Assert.assertEquals(actualSecondWord, expectedSecondWord);
        Assert.assertEquals(actualThirdWord, expectedThirdWord);
    }
}