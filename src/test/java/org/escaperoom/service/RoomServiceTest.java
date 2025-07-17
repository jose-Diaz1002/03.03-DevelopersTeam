package org.escaperoom.model.service;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.notification.Observer;
import org.escaperoom.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class RoomServiceTest {

    private RoomDAO roomDAO;
    private RoomService roomService;
    private Observer observer;

    @BeforeEach
    void setUp() {
        roomDAO = mock(RoomDAO.class);
        roomService = new RoomService(roomDAO);
        observer = mock(Observer.class);

        roomService.addObserver(observer);
    }

    @Test
    void whenCreateRoom_thenNotifyObservers() throws RoomCreationException {
        // Crear un Room válido
        Room room = new Room();
        room.setName("Sala de Escape 1");
        room.setEscapeRoomId(1);
        room.setPrice(BigDecimal.valueOf(20.0));
        room.setQuantityAvailable(5);

        // Ejecutar el método
        roomService.createRoom(room);

        // Verificar que el DAO llamó al método create con el room
        verify(roomDAO).create(room);

        // Verificar que el observer fue notificado con "roomCreated" y el room
        verify(observer).update("roomCreated", room);
    }
}
