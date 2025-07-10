package org.escaperoom.input;

import java.util.Scanner;

public class ScannerInputReader implements InputReader {

    private final Scanner scanner;

    public ScannerInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, introduce un número entero válido: ");
            }
        }
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    @Override
    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, introduce un número decimal válido: ");
            }
        }
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        return readDouble();
    }

    @Override
    public boolean readBoolean() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s") || input.equals("sí") || input.equals("si") || input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.print("Por favor, responde con S/N: ");
            }
        }
    }

    public boolean readBoolean(String prompt) {
        System.out.print(prompt);
        return readBoolean();
    }
}
