package org.escaperoom.exception;

public class RoomUpdateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RoomUpdateException(String message) {
        super(message);
    }

    public RoomUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomUpdateException(Throwable cause) {
        super(cause);
    }
}
