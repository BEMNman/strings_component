package com.epam.strings.text.expression.calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionCalculatorTest {

    private static final String EXPRESSION_TEST_ONE = "[23*]";
    private static final String EXPRESSION_TEST_TWO = "[39-5-]";
    private static final String EXPRESSION_TEST_THREE = "[23+5+9+]";
    private static final String EXPRESSION_TEST_FOUR = "[18/8/]";

    @Test
    public void testCalculateShouldReturnSixWhenExpressionStringTwoThreeMultiply() {
        ExpressionCalculator calculator = new ExpressionCalculator(EXPRESSION_TEST_ONE);
        int expectedResult = 6;

        int actualResult = calculator.calculate();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculateShouldReturnMinusOneWhenExpressionStringThreeNineFiveMinus() {
        ExpressionCalculator calculator = new ExpressionCalculator(EXPRESSION_TEST_TWO);
        int expectedResult = -1;

        int actualResult = calculator.calculate();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculateShouldReturnNineteenWhenExpressionStringTwoThreeFiveNinePlus() {
        ExpressionCalculator calculator = new ExpressionCalculator(EXPRESSION_TEST_THREE);
        int expectedResult = 19;

        int actualResult = calculator.calculate();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCalculateShouldReturnOneWhenExpressionStringOneEightEightDivide() {
        ExpressionCalculator calculator = new ExpressionCalculator(EXPRESSION_TEST_FOUR);
        int expectedResult = 1;

        int actualResult = calculator.calculate();

        Assert.assertEquals(actualResult, expectedResult);
    }
}