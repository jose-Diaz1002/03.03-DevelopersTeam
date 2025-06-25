package org.escaperoom.service.interfaces;

import org.escaperoom.model.Room;

public interface EscapeRoomService {

    void createEscapeRoom(String name);
    void addRoomToEscapeRoom(int escapeRoomId, Room room);
    void removeRoomFromEscapeRoom(int escapeRoomId, int roomId);
    double getInventoryValue(int escapeRoomId);
}
