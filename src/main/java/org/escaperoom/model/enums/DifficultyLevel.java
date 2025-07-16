package org.escaperoom.model.enums;

public enum DifficultyLevel {
    EASY,
    MEDIUM,
    HARD,
    EXPERT;

    // Método opcional si necesitas obtenerlo desde una cadena segura (ej: desde consola o BD)
    public static DifficultyLevel fromString(String value) {
        for (DifficultyLevel level : values()) {
            if (level.name().equalsIgnoreCase(value.trim())) {
                return level;
            }
        }
        throw new IllegalArgumentException("Nivel de dificultad inválido: " + value);
    }

}
