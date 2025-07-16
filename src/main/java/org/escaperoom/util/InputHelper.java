package org.escaperoom.util;

import org.escaperoom.util.InputReader;

import java.math.BigDecimal;

public class InputHelper {

    public static final int DEFAULT_MAX_ATTEMPTS = 3;

    public static Integer readIntWithAttempts(InputReader inputReader, String prompt, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                String input = inputReader.readLine(prompt);
                return InputValidator.validatePositiveInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intento " + (attempts + 1) + " de " + maxAttempts);
                attempts++;
            }
        }
        System.out.println("❌ Número máximo de intentos alcanzado. Abortando.");
        return null;
    }

    public static String readStringWithAttempts(InputReader inputReader, String prompt, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                return InputValidator.readNonEmptyString(inputReader, prompt);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intento " + (attempts + 1) + " de " + maxAttempts);
                attempts++;
            }
        }
        System.out.println("❌ Número máximo de intentos alcanzado. Abortando.");
        return null;
    }

    public static <E extends Enum<E>> E readEnumWithAttempts(InputReader inputReader, String prompt, Class<E> enumClass, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                return InputValidator.readEnum(inputReader, prompt, enumClass);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intento " + (attempts + 1) + " de " + maxAttempts);
                attempts++;
            }
        }
        System.out.println("❌ Número máximo de intentos alcanzado. Abortando.");
        return null;
    }

    public static BigDecimal readBigDecimalWithAttempts(InputReader inputReader, String prompt, int maxAttempts) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                return InputValidator.readPositiveBigDecimal(inputReader, prompt);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intento " + (attempts + 1) + " de " + maxAttempts);
                attempts++;
            }
        }
        System.out.println("❌ Número máximo de intentos alcanzado. Abortando.");
        return null;
    }
}
