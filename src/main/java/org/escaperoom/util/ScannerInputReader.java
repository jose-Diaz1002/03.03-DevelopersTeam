package org.escaperoom.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerInputReader implements InputReader {

    private final Scanner scanner;

    public ScannerInputReader() {
        this.scanner = new Scanner(System.in);
    }

    // Constructor para permitir la inyección de un Scanner personalizado (por ejemplo, para pruebas)
    public ScannerInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("❌ Entrada inválida. No se puede dejar el campo vacío.");
            return readLine(prompt);
        }
        return input;
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Entrada inválida. No se puede dejar el campo vacío.");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Introduce un número entero válido.");
            }
        }
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ Entrada inválida. No se puede dejar el campo vacío.");
                continue;
            }
            try {
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Introduce un número decimal válido.");
            }
        }
    }

    @Override
    public boolean readBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (s/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s") || input.equals("si") || input.equals("y") || input.equals("yes") || input.equals("true")) {
                return true;
            } else if (input.equals("n") || input.equals("no") || input.equals("false")) {
                return false;
            } else {
                System.out.println("❌ Entrada inválida. Por favor, responde con 's' o 'n'.");
            }
        }
    }
}
