package org.escaperoom.util;


import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    public static int validateIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    public static int validatePositiveIntInput(String prompt) {
        while (true) {
            int value = validateIntInput(prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("Value must be a positive integer.");
        }
    }

    public static int validateIdInput(String prompt) {
        while (true) {
            int id = validateIntInput(prompt);
            if (id > 0) {
                return id;
            }
            System.out.println("Invalid input. ID must be greater than zero.");
        }
    }

    public static String validateStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Invalid input. Please enter a non-empty text.");
        }
    }

    public static double validatePriceInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();
                scanner.nextLine();
                if (price >= 0) {
                    return Math.round(price * 100.0) / 100.0;
                } else {
                    System.out.println("Price must be a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.nextLine();
            }
        }
    }

    public static BigDecimal validatePositiveBigDecimal(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                BigDecimal value = new BigDecimal(input);
                if (value.compareTo(BigDecimal.ZERO) >= 0) {
                    return value;
                }
                System.out.println("Value must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
            }
        }
    }

    public static boolean validateBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (s/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("s")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            }
            System.out.println("Invalid input. Please enter 's' or 'n'.");
        }
    }

    public static String validateEmailInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (validateEmail(input)) {
                return input;
            }
            System.out.println("Invalid email format. Please enter a valid email.");
        }
    }

    public static boolean validateEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static <T extends Enum<T>> T validateEnumInput(String prompt, Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();

        System.out.println(prompt);
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }

        while (true) {
            int choice = validateIntInput("Choose an option: ");
            if (choice >= 1 && choice <= values.length) {
                return values[choice - 1];
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static String enumOptions(Class<? extends Enum<?>> enumClass) {
        StringBuilder options = new StringBuilder();
        Object[] constants = enumClass.getEnumConstants();
        for (int i = 0; i < constants.length; i++) {
            options.append(constants[i].toString());
            if (i < constants.length - 1) {
                options.append(", ");
            }
        }
        return options.toString();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
