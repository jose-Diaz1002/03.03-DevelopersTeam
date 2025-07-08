package org.escaperoom.exception;

public class EscapeRoomCreationException extends Exception {

    private static final long serialVersionUID = 1L;


    public EscapeRoomCreationException(String message) {
        super(message);
    }

    public EscapeRoomCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public EscapeRoomCreationException(Throwable cause) {
        super(cause);
    }
}

