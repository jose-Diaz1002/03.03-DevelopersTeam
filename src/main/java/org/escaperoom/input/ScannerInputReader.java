package org.escaperoom.input;

import java.util.Scanner;

public class ScannerInputReader implements InputReader {

    private final Scanner scanner;

    public ScannerInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Introduce un número entero.");
            }
        }
    }
}
