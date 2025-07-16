package org.escaperoom.exception;

public class ClueNotFoundException {
    private final String message;

    public ClueNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
