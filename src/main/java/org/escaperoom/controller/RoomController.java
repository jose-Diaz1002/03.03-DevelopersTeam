package org.escaperoom.controller;

import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.model.service.RoomService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class RoomController {

    private final InputReader inputReader;
    private final RoomService roomService;

    public RoomController(InputReader inputReader, RoomService roomService) {
        this.inputReader = inputReader;
        this.roomService = roomService;
    }

    public void createRoom() throws RoomCreationException {
        try {
            int escapeRoomId = inputReader.readInt("ID del EscapeRoom: ");
            String name = inputReader.readString("Nombre de la sala: ");

            DifficultyLevel difficulty = null;
            while (difficulty == null) {
                String difficultyInput = inputReader.readString("Dificultad (Easy, Medium, Hard, Expert): ");
                try {
                    difficulty = DifficultyLevel.fromString(difficultyInput.trim());
                } catch (IllegalArgumentException e) {
                    System.out.println("Dificultad no válida. Intenta nuevamente.");
                }
            }

            BigDecimal price = BigDecimal.valueOf(inputReader.readDouble("Precio: "));
            int quantity = inputReader.readInt("Cantidad disponible: ");

            Room room = new Room(escapeRoomId, name, difficulty, price, quantity);
            roomService.createRoom(room);

            System.out.println("Sala creada con éxito.");

        } catch (RoomCreationException e) {
            System.out.println("Error al crear Room: " + e.getMessage());
        }
    }

    public void listRoomsByEscapeRoom() {
        try {
            int escapeRoomId = inputReader.readInt("ID del EscapeRoom: ");
            List<Room> rooms = roomService.getRoomsByEscapeRoomId(escapeRoomId);

            if (rooms.isEmpty()) {
                System.out.println("No hay salas para este EscapeRoom.");
            } else {
                rooms.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al listar salas: " + e.getMessage());
        }
    }
}
