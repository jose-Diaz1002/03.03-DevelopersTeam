package org.escaperoom.exception;



public class DecorationObjectCreationException extends Exception {

    public DecorationObjectCreationException(String message) {
        super(message);
    }

    public DecorationObjectCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}