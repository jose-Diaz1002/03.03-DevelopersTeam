package org.escaperoom.exception;

public class EscapeRoomDeletionException extends Throwable {
    public EscapeRoomDeletionException() {
        super("Error al eliminar el Escape Room");
    }
    public EscapeRoomDeletionException(String s) {
        super(s);
    }

    public EscapeRoomDeletionException(String s, Exception e) {
    }
}
