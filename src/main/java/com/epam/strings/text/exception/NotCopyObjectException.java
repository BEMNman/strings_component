package com.epam.strings.text.exception;

public class NotCopyObjectException extends Exception{
    public NotCopyObjectException() {
    }

    public NotCopyObjectException(String message) {
        super(message);
    }

    public NotCopyObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCopyObjectException(Throwable cause) {
        super(cause);
    }

    public NotCopyObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
