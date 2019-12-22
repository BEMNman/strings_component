package com.epam.strings.text.creator;

import com.epam.strings.text.entity.TokenLeaf;
import com.epam.strings.text.entity.TypeLeaf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenLeafCreatorTest {

    private final TokenLeafCreator leafCreator = new TokenLeafCreator();

    @Test
    public void createTokenLeafTestShouldReturnLeafWithTypeWordWhenArgumentIsWord() {
        String argument = "test";
        TypeLeaf expectedTypeWord = TypeLeaf.WORD;

        TokenLeaf word = leafCreator.createTokenLeaf(argument);
        TypeLeaf actualTypeWord = word.getType();
        String actualValue = word.getValue();

        Assert.assertEquals(actualTypeWord, expectedTypeWord);
        Assert.assertEquals(actualValue, argument);
    }

    @Test
    public void createTokenLeafTestShouldReturnLeafWithTypeExpressionWhenArgumentIsExpression() {
        String argument = "[14+]";
        String valueCalculatedExpression = "5";
        TypeLeaf expectedTypeWord = TypeLeaf.EXPRESSION;

        TokenLeaf expression = leafCreator.createTokenLeaf(argument);
        TypeLeaf actualTypeWord = expression.getType();
        String actualValue = expression.getValue();

        Assert.assertEquals(actualTypeWord, expectedTypeWord);
        Assert.assertEquals(actualValue, valueCalculatedExpression);
    }

    @Test
    public void testCreateMarkShouldReturnLeafWithTypeMarkWhenArgumentIsMarkOfSentence() {
        String argument = "...";
        TypeLeaf expectedTypeMark = TypeLeaf.MARK;

        TokenLeaf mark = leafCreator.createMark(argument);
        TypeLeaf actualTypeWord = mark.getType();
        String actualValue = mark.getValue();

        Assert.assertEquals(actualTypeWord, expectedTypeMark);
        Assert.assertEquals(actualValue, argument);
    }
}