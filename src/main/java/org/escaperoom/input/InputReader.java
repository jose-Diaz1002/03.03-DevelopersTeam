package org.escaperoom.input;

public interface InputReader {
    String readString();
    int readInt();
    double readDouble();
    boolean readBoolean();

    // Opcional, más amigable:
    String readString(String prompt);
    int readInt(String prompt);
    double readDouble(String prompt);
    boolean readBoolean(String prompt);
}
