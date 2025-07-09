package org.escaperoom.model.enums;

public enum ClueTheme {
    MYSTERY,
    HORROR,
    FANTASY,
    SCI_FI,
    HISTORICAL,
    ADVENTURE;

    public static ClueTheme fromString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El tema no puede ser nulo.");
        }

        return switch (input.trim().toLowerCase()) {
            case "mystery" -> MYSTERY;
            case "horror" -> HORROR;
            case "fantasy" -> FANTASY;
            case "sci-fi", "scifi", "sci fi" -> SCI_FI;
            case "historical" -> HISTORICAL;
            case "adventure" -> ADVENTURE;
            default -> throw new IllegalArgumentException("Tema no válido: " + input);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case MYSTERY -> "Mystery";
            case HORROR -> "Horror";
            case FANTASY -> "Fantasy";
            case SCI_FI -> "Sci-Fi";
            case HISTORICAL -> "Historical";
            case ADVENTURE -> "Adventure";
        };
    }
}




