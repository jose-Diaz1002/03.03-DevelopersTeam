package org.escaperoom.input;

import java.util.LinkedList;
import java.util.Queue;

public class TestInputReader implements InputReader {
    private final Queue<String> inputs = new LinkedList<>();

    public void addInput(String input) {
        inputs.add(input);
    }

    @Override
    public String readLine() {
        return null;
    }

    @Override
    public int readInt(String prompt) {
        return 0;
    }

    @Override
    public String readLine(String prompt) {
        return inputs.poll();
    }
}
