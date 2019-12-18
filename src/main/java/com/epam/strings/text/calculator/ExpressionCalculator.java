package com.epam.strings.text.calculator;

import com.epam.strings.text.exception.ArithmeticOperationException;

import java.util.Stack;

public class ExpressionCalculator {

    private final Stack<Integer> stack = new Stack();

    public String calculate(String expression) throws ArithmeticOperationException {
        char[] chars = expression.toCharArray();
        int amountChars = chars.length;
        int indexFirstCharExpression = 1;
        int indexLastCharExpression = amountChars - 1;
        for (int i = indexFirstCharExpression; i < indexLastCharExpression; i++) {
            char currentChar = chars[i];
            if (Character.isDigit(currentChar)) {
                int number = Character.digit(currentChar, 10);
                stack.add(number);
            } else {
                calculatePartExpression(currentChar);
            }
        }
        return stack.pop().toString();
    }

    private void calculatePartExpression(char currentChar) throws ArithmeticOperationException {
        switch (currentChar) {
            case '+':
                stack.add(sum());
                break;
            case '-':
                stack.add(minus());
                break;
            case '*':
                stack.add(multiply());
                break;
            case '/':
                stack.add(divide());
                break;
            default:
                throw new ArithmeticOperationException(currentChar + " isn't arithmetic operation");
        }
    }

    private int sum() {
        int result = stack.pop();
        while (!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }

    private int minus() {
        int result = stack.pop();
        while (!stack.empty()) {
            result -= stack.pop();
        }
        return result;
    }

    private int multiply() {
        int result = stack.pop();
        while (!stack.empty()) {
            result *= stack.pop();
        }
        return result;
    }

    private int divide() {
        int result = stack.pop();
        while (!stack.empty()) {
            result /= stack.pop();
        }
        return result;
    }
}
