package com.epam.strings.text.exception;

public class ArithmeticOperationException extends Exception {
    public ArithmeticOperationException() {
    }

    public ArithmeticOperationException(String message) {
        super(message);
    }

    public ArithmeticOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArithmeticOperationException(Throwable cause) {
        super(cause);
    }

    public ArithmeticOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
