package org.escaperoom.model;

import org.escaperoom.model.enums.DifficultyLevel;

/**
 * Represents an Escape Room with its details.
 *
 */
public class EscapeRoom {

    private int id;
    private String name;

    public EscapeRoom(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
