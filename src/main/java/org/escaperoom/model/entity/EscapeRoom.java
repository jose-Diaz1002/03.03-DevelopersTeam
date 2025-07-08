package org.escaperoom.model.entity;


public class EscapeRoom {
    private int id;
    private String name;

    public EscapeRoom() {
    }

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

    @Override
    public String toString() {
        return String.format(
                "EscapeRoom{id=%d, name='%s'}",
                id, name);
    }
}
