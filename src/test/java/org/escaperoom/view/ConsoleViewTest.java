package org.escaperoom.view;

import org.escaperoom.util.InputReader;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleViewTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private ConsoleView consoleView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testPrintWelcomeMessage() {
        consoleView = new ConsoleView(null); // No se usa inputReader aquí
        consoleView.printWelcomeMessage();
        String output = outputStream.toString();
        assertTrue(output.contains("Escape Room"));
    }

    @Test
    void testPrintMainMenu() {
        consoleView = new ConsoleView(null);
        consoleView.printMainMenu();
        String output = outputStream.toString();
        assertTrue(output.contains("ESCAPE ROOM VIRTUAL"));
    }

    @Test
    void testReadInput() {
        consoleView = new ConsoleView(new InputReader() {
            @Override
            public String readLine(String prompt) {
                return "hola";
            }

            @Override
            public int readInt(String prompt) {
                return 0;
            }

            @Override
            public BigDecimal readBigDecimal(String prompt) {
                return BigDecimal.ZERO;
            }

            @Override
            public boolean readBoolean(String prompt) {
                return false;
            }
        });

        String result = consoleView.readInput("Escribe algo: ");
        assertEquals("hola", result);
    }
}