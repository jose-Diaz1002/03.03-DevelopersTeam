package org.escaperoom.model.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.entity.Room;
import org.escaperoom.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    private RoomDAO roomDAO;
    private ClueDAO clueDAO;
    private DecorationObjectDAO decorationDAO;
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        roomDAO = mock(RoomDAO.class);
        clueDAO = mock(ClueDAO.class);
        decorationDAO = mock(DecorationObjectDAO.class);
        inventoryService = new InventoryService(roomDAO, clueDAO, decorationDAO);
    }

    @Test
    void testCalculateInventoryValueByEscapeRoomId() throws Exception {
        int escapeRoomId = 1;
        int roomId = 101;

        Room room = new Room();
        room.setRoomId(roomId);
        room.setPrice(new BigDecimal("100.00"));
        room.setQuantityAvailable(2);

        Clue clue = new Clue();
        clue.setPrice(new BigDecimal("20.00"));
        clue.setQuantityAvailable(3);

        DecorationObject decoration = new DecorationObject();
        decoration.setPrice(new BigDecimal("10.00"));
        decoration.setQuantityAvailable(5);

        when(roomDAO.findByEscapeRoomId(escapeRoomId)).thenReturn(List.of(room));
        when(clueDAO.findByRoomId(roomId)).thenReturn(List.of(clue));
        when(decorationDAO.findByRoomId(roomId)).thenReturn(List.of(decoration));

        BigDecimal result = inventoryService.calculateInventoryValueByEscapeRoomId(escapeRoomId);

        BigDecimal expected = new BigDecimal("310.00");
        assertEquals(expected, result);
    }
}
