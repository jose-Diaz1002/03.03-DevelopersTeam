package org.escaperoom.controller;

import org.escaperoom.controller.menu.EscapeRoomMenuController;
import org.escaperoom.util.InputReader;
import org.escaperoom.view.ConsoleView;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EscapeRoomControllerTest {

    @Test
    void testInvalidOptionPrintsError() {
        FakeInputReader inputReader = new FakeInputReader();
        FakeConsoleView view = new FakeConsoleView();
        EscapeRoomMenuController controller = new EscapeRoomMenuController(inputReader, view);

        inputReader.addInput("999"); // opción inválida
        inputReader.addInput("0");   // salir del bucle

        controller.execute();

        assertTrue(view.containsMessage("Opción inválida"));
    }

    private static class FakeConsoleView extends ConsoleView {
        private final List<String> messages = new ArrayList<>();

        public FakeConsoleView() {
            super(new InputReader() {
                @Override
                public String readLine(String prompt) {
                    return "";
                }

                @Override
                public int readInt(String prompt) {
                    return 0;
                }

                @Override
                public boolean readBoolean(String prompt) {
                    return false;
                }

                @Override
                public BigDecimal readBigDecimal(String prompt) {
                    return BigDecimal.ZERO;
                }
            });
        }

        @Override
        public void printSuccess(String message) {
            messages.add("✔ " + message);
        }

        @Override
        public void printError(String message) {
            messages.add("✘ " + message);
        }

        public boolean containsMessage(String text) {
            return messages.stream().anyMatch(m -> m.contains(text));
        }
    }

    private static class FakeInputReader implements InputReader {
        private final Queue<String> inputs = new LinkedList<>();

        public void addInput(String input) {
            inputs.add(input);
        }

        @Override
        public String readLine(String prompt) {
            return inputs.poll(); // o puedes usar un valor por defecto si está vacío
        }

        @Override
        public int readInt(String prompt) {
            return Integer.parseInt(inputs.poll());
        }

        @Override
        public boolean readBoolean(String prompt) {
            return Boolean.parseBoolean(inputs.poll());
        }

        @Override
        public BigDecimal readBigDecimal(String prompt) {
            return new BigDecimal(inputs.poll());
        }
    }
}