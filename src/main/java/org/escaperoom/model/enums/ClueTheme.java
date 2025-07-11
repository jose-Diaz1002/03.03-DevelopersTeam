package org.escaperoom.model.enums;

public enum ClueTheme {
    MYSTERY,
    HORROR,
    FANTASY,
    SCI_FI,
    HISTORICAL,
    ADVENTURE;

    public static ClueTheme fromString(String input) {
        for (ClueTheme theme : ClueTheme.values()) {
            if (theme.name().equalsIgnoreCase(input)) {
                return theme;
            }
        }
        throw new IllegalArgumentException("Tema de pista no válido: " + input);
    }

}




