package org.escaperoom.exception;

public class ClueNotFoundException extends Throwable {
    private final String message;

    public ClueNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
