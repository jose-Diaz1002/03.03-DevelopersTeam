package org.escaperoom.controller.command.escapeRoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.room.CreateRoomCommand;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.service.EscapeRoomService;

public class CreateEscapeRoomCommand implements Command {

    private final EscapeRoomService escapeRoomService;
    private final InputReader inputReader;

    public CreateEscapeRoomCommand(InputReader inputReader) {
        this.escapeRoomService = EscapeRoomServiceFactory.create();
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        try {
            String name = inputReader.readLine("Nombre del Escape Room: ").trim();
            if (name.isEmpty()) {
                System.out.println("❌ El nombre no puede estar vacío.");
                return;
            }

            EscapeRoom escapeRoom = new EscapeRoom();
            escapeRoom.setName(name);

            escapeRoomService.createEscapeRoom(escapeRoom);
            System.out.println("✅ Escape Room creado con ID: " + escapeRoom.getId());

            String respuesta = inputReader.readLine("¿Quieres añadir una sala ahora? (S/N): ").trim().toUpperCase();
            if (respuesta.equals("S")) {
                new CreateRoomCommand(inputReader, escapeRoom.getId()).execute();
            } else {
                System.out.println("➡️ Puedes añadir salas más tarde desde el menú de Rooms.");
            }

        } catch (EscapeRoomCreationException e) {
            System.out.println("❌ Error al crear el Escape Room: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}