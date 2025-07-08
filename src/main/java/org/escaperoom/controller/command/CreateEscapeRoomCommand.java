package org.escaperoom.controller.command;

import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.dao.mysql.MySQLEscapeRoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.EscapeRoom;

import java.math.BigDecimal;
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
            System.out.print("Valor inventario inicial: ");
            double value = Double.parseDouble(sc.nextLine());

            EscapeRoom room = new EscapeRoom();
            room.setName(name);
            //Revisar el cast de double a BigDecimal
            room.setTotalInventoryValue(BigDecimal.valueOf(value));

            dao.create(room);
            System.out.println("Escape Room creado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al crear Escape Room: " + e.getMessage());
        }
    }
}
