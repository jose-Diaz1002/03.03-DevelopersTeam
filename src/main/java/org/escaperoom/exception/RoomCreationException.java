package org.escaperoom.exception;

public class RoomCreationException extends Exception {

    private static final long serialVersionUID = 1L;

    public RoomCreationException(String message) {
        super(message);
    }

    public RoomCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomCreationException(Throwable cause) {
        super(cause);
    }
}
