package org.escaperoom.model.enums;

public enum ClueTheme {
    MYSTERY,
    HORROR,
    FANTASY,
    SCI_FI,
    HISTORICAL,
    ADVENTURE;

    public static ClueTheme fromString(String value) {
        try {
            return ClueTheme.valueOf(value.trim().toUpperCase().replace("-", "_").replace(" ", "_"));
        } catch (Exception e) {
            throw new IllegalArgumentException("❌ Tema no reconocido: " + value);
        }
    }
}




