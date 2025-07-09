package org.escaperoom.controller.command;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.dao.mysql.MySQLEscapeRoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateEscapeRoomCommand implements Command {
    private final EscapeRoomDAO dao;


    public CreateEscapeRoomCommand() {
        try {
            this.dao = new MySQLEscapeRoomDAO(MySQLConnection.getInstance().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nombre del Escape Room: ");
            String name = sc.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("El nombre del Escape Room no puede estar vacío.");
                return;
            }
            EscapeRoom room = new EscapeRoom();
            room.setName(name);

            dao.create(room);  // persiste y setea el ID automáticamente
            System.out.println("Escape Room creado con éxito con ID: " + room.getId());

            // Preguntar si quiere añadir una sala ahora
            System.out.print("¿Quieres añadir una sala ahora? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                // Crear Room con escapeRoomId asociado
                CreateRoomCommand createRoomCommand = new CreateRoomCommand(sc, room.getId());
                createRoomCommand.execute();
            }

        } catch (Exception e) {
            System.out.println("Error al crear Escape Room: " + e.getMessage());
        }
    }

}
