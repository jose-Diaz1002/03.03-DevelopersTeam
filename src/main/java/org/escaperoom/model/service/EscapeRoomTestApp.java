package org.escaperoom.model.service;

import org.escaperoom.model.entity.EscapeRoom;

public class EscapeRoomTestApp {
    public static void main(String[] args) {
        EscapeRoomService service = new EscapeRoomService(
                new EscapeRoomDAOImpl(),
                new RoomDAOImpl(),
                new ClueDAOImpl(),
                new DecorationObjectDAOImpl(),
                new TicketDAOImpl(),
                new AchievementDAOImpl(),
                new InventoryDAOImpl()
        );

        EscapeRoom room = new EscapeRoom("Haunted House");
        service.createEscapeRoom(room);

        // HACER OTRAS pruebas...
    }
}
