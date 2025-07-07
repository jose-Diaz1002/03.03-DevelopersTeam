package org.escaperoom.model.entity;

public class Room {
    private int id;
    private String name;
    private int capacity;
    private int escapeRoomId;

    public Room() {}

    public Room(String name, int capacity, int escapeRoomId) {
        this.name = name;
        this.capacity = capacity;
        this.escapeRoomId = escapeRoomId;
    }

    public Room(int id, String name, int capacity, int escapeRoomId) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.escapeRoomId = escapeRoomId;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getEscapeRoomId() { return escapeRoomId; }
    public void setEscapeRoomId(int escapeRoomId) { this.escapeRoomId = escapeRoomId; }
}
