package org.escaperoom.util;
import org.escaperoom.model.enums.DifficultyLevel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputValidator {

    private InputValidator() {
        // Constructor privado para evitar instanciación
        throw new UnsupportedOperationException("Esta clase no puede ser instanciada.");
    }

    /**
     * Lee una cadena de texto del usuario y lanza una excepción si está vacía o nula.
     *
     * @param inputReader El lector de entrada.
     * @param prompt      El mensaje a mostrar al usuario.
     * @return La cadena leída, sin espacios en blanco al principio o al final.
     */
    public static String readNonEmptyString(InputReader inputReader, String prompt) {
        String input = inputReader.readLine(prompt);
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ El campo no puede estar vacío.");
        }
        return input.trim();
    }


    /**
     * Lee un nivel de dificultad del usuario y lanza una excepción si es inválido.
     *
     * @param inputReader El lector de entrada.
     * @param prompt      El mensaje a mostrar al usuario.
     * @return El nivel de dificultad correspondiente.
     */
    public static DifficultyLevel readDifficultyLevel(InputReader inputReader, String prompt) {
        String input = readNonEmptyString(inputReader, prompt);
        try {
            return DifficultyLevel.fromString(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("❌ Dificultad inválida. Debe ser: Easy, Medium, Hard o Expert.");
        }
    }


    /**
     * Lee un BigDecimal positivo del usuario y lanza una excepción si es inválido.
     *
     * @param inputReader El lector de entrada.
     * @param prompt      El mensaje a mostrar al usuario.
     * @return El BigDecimal leído, que debe ser positivo.
     */
    public static BigDecimal readPositiveBigDecimal(InputReader inputReader, String prompt) {
        String input = readNonEmptyString(inputReader, prompt);
        try {
            BigDecimal value = new BigDecimal(input);
            if (value.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("❌ El precio debe ser un número positivo.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("❌ Entrada inválida. Debe ser un número decimal válido.");
        }
    }

    /**
     * Lee un entero positivo del usuario y lanza una excepción si es inválido.
     *
     * @param inputReader El lector de entrada.
     * @param prompt      El mensaje a mostrar al usuario.
     * @return El entero leído, que debe ser mayor o igual a 0.
     */
    public static int readPositiveInt(InputReader inputReader, String prompt) {
        String input = readNonEmptyString(inputReader, prompt);
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("❌ El número debe ser mayor o igual a 0.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("❌ Entrada inválida. Debe ser un número entero válido.");
        }
    }

    /**
     * Lee un entero positivo del usuario y lanza una excepción si es inválido.
     *
     * @param inputReader El lector de entrada.
     * @param prompt      El mensaje a mostrar al usuario.
     * @return El entero leído, que debe ser mayor o igual a 0.
     */
    public static int readPositiveIntOrZero(InputReader inputReader, String prompt) {
        String input = readNonEmptyString(inputReader, prompt);
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("❌ El número debe ser mayor o igual a 0.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("❌ Entrada inválida. Debe ser un número entero válido.");
        }
    }

    /**
     * Verifica si una cadena es válida (no vacía y no solo espacios).
     */
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Valida una respuesta de tipo Sí/No.
     * Acepta S, N, s, n y sus variantes con espacios.
     */
    public static boolean isAffirmative(String input) {
        return input != null && input.trim().equalsIgnoreCase("S");
    }

    public static boolean isNegative(String input) {
        return input != null && input.trim().equalsIgnoreCase("N");
    }

    /**
     * Comprueba que un número sea positivo o cero.
     */
    public static boolean isPositiveNumber(int number) {
        return number >= 0;
    }

    public static boolean isPositiveDecimal(java.math.BigDecimal number) {
        return number != null && number.compareTo(java.math.BigDecimal.ZERO) >= 0;
    }

    // ✅ Nuevo método genérico para enums
    public static <E extends Enum<E>> E readEnum(InputReader inputReader, String prompt, Class<E> enumClass) {
        String input = readNonEmptyString(inputReader, prompt);
        try {
            return Enum.valueOf(enumClass, input.toUpperCase().replace("-", "_"));
        } catch (IllegalArgumentException e) {
            String validValues = Arrays.stream(enumClass.getEnumConstants())
                    .map(Enum::name)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("❌ Valor inválido. Opciones válidas: " + validValues);
        }
    }

    public static String readEmailString(InputReader inputReader, String prompt) throws IllegalArgumentException {
        String email = readNonEmptyString(inputReader, prompt);
        // Regex básico para validar email con case-insensitive
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("❌ El email no es válido.");
        }
        return email;
    }

    public static String readString(InputReader inputReader, String s) {
        String input = inputReader.readLine(s);
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ El campo no puede estar vacío.");
        }
        return input.trim();
    }

    public static int validatePositiveInt(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ El campo no puede estar vacío.");
        }
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("❌ El número debe ser mayor o igual a 0.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("❌ Entrada inválida. Debe ser un número entero válido.");
        }
    }
}
