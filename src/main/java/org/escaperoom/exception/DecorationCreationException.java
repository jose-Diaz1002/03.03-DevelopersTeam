package org.escaperoom.exception;

public class DecorationCreationException extends Exception {
    public DecorationCreationException(String message) {
        super(message);
    }

    public DecorationCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
