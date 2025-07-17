package org.escaperoom.model.service;

import org.escaperoom.dao.common.*;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.exception.EscapeRoomDeletionException;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.service.EscapeRoomService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EscapeRoomServiceTest {

    private EscapeRoomService service;
    private EscapeRoomDAO escapeRoomDAO;

    @BeforeEach
    void setUp() {
        escapeRoomDAO = mock(EscapeRoomDAO.class);

        service = new EscapeRoomService(
                escapeRoomDAO,
                mock(RoomDAO.class),
                mock(ClueDAO.class),
                mock(DecorationObjectDAO.class),
                mock(TicketDAO.class),
                mock(AchievementDAO.class),
                mock(InventoryDAO.class)
        );
    }

    @Test
    void testCreateEscapeRoom_valid() throws EscapeRoomCreationException {
        EscapeRoom room = new EscapeRoom();
        room.setName("Sala Test");

        assertDoesNotThrow(() -> service.createEscapeRoom(room));
        verify(escapeRoomDAO).create(room);
    }

    @Test
    void testCreateEscapeRoom_invalidName() throws EscapeRoomCreationException {
        EscapeRoom room = new EscapeRoom(); // nombre nulo o vacío

        EscapeRoomCreationException exception = assertThrows(EscapeRoomCreationException.class, () ->
                service.createEscapeRoom(room));

        assertTrue(exception.getMessage().contains("vacío"));
    }

    @Test
    void testGetAllEscapeRooms() throws EscapeRoomCreationException {
        EscapeRoom room1 = new EscapeRoom();
        EscapeRoom room2 = new EscapeRoom();
        when(escapeRoomDAO.findAll()).thenReturn(Arrays.asList(room1, room2));

        List<EscapeRoom> result = service.getAllEscapeRooms();

        assertEquals(2, result.size());
        verify(escapeRoomDAO).findAll();
    }

    @Test
    void testUpdateEscapeRoom_invalidId() throws EscapeRoomCreationException {
        EscapeRoom room = new EscapeRoom();
        room.setId(0);
        room.setName("Sala válida");

        EscapeRoomCreationException exception = assertThrows(EscapeRoomCreationException.class, () ->
                service.updateEscapeRoom(room));

        assertTrue(exception.getMessage().contains("inválido"));
    }

    @Test
    void testDeleteEscapeRoomById_invalidId() {
        EscapeRoomDeletionException exception = assertThrows(EscapeRoomDeletionException.class, () ->
                service.deleteEscapeRoomById(0));

        assertTrue(exception.getMessage().contains("inválido"));
    }
}