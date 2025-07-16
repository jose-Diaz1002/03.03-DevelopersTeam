package org.escaperoom.util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static int validateIntInput(String prompt) {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                valid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
            scanner.nextLine();
        }
        return input;
    }

    public static String validateStringInput(String prompt) {
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a non-empty text.");
            }
        }
        return input;
    }

    public static boolean validateBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }
    }

    public static int validateIdInput(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Invalid input. ID must be greater than zero.");
                }
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
            }

        }
    }

    public static String validateEmailInput(String prompt) {
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (validateEmail(input)) {
                valid = true;
            } else {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        }
        return input;
    }

    public static boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static double validatePriceInput(String prompt) {
        double price = 0.0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price >= 0) {
                    valid = true;
                } else {
                    System.out.println("Price must be a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }

        price = Math.round(price * 100.0) / 100.0;
        return price;
    }

    public static <T extends Enum<T>> String validateEnumInput(String prompt, Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();

        System.out.println(prompt);
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }

        int choice;
        while (true) {
            choice = validateIntInput("Choose an option: ");
            if (choice >= 1 && choice <= values.length) {
                return values[choice - 1].name();
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}