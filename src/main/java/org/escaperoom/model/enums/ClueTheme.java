package org.escaperoom.model.enums;

public enum ClueTheme {

    TERROR,
    ROMANTIC,
    ACTION,
    PSYCHOLOGICAL;

    public static ClueTheme fromString(String value) {
        for (ClueTheme theme : values()) {
            if (theme.name().equalsIgnoreCase(value.trim())) {
                return theme;
            }
        }
        throw new IllegalArgumentException("Tema de pista inválido: " + value);
    }

}
