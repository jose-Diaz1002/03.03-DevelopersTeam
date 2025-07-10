package org.escaperoom.input;

import java.util.Queue;
import java.util.LinkedList;

public class TestInputReader implements InputReader {
    private final Queue<String> inputs = new LinkedList<>();

    public void addInput(String input) {
        inputs.add(input);
    }

    @Override
    public String readString() {
        return null;
    }

    @Override
    public int readInt() {
        return 0;
    }

    @Override
    public double readDouble() {
        return 0;
    }

    @Override
    public boolean readBoolean() {
        return false;
    }

    @Override
    public String readString(String prompt) {
        return null;
    }

    @Override
    public int readInt(String prompt) {
        return 0;
    }

    @Override
    public double readDouble(String prompt) {
        return 0;
    }

    @Override
    public boolean readBoolean(String prompt) {
        return false;
    }
}
