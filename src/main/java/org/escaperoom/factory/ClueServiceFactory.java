package org.escaperoom.factory;

import org.escaperoom.controller.command.clue.DeleteClueCommand;
import org.escaperoom.controller.command.clue.ListCluesCommand;
import org.escaperoom.controller.command.clue.UpdateClueCommand;
import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputReader;

import java.sql.SQLException;

/**
 * Fábrica para crear instancias de ClueService y comandos relacionados.
 */
public class ClueServiceFactory {

    // Constructor privado para evitar instanciación
    private ClueServiceFactory() {
    }

    /**
     * Crea una instancia de ClueService con su DAO MySQL.
     */
    public static ClueService create() {
        try {
            return new ClueService(
                    new MySQLClueDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al crear ClueService: " + e.getMessage(), e);
        }
    }

    /**
     * Crea un comando para listar pistas.
     */
    public static ListCluesCommand createListCluesCommand(InputReader inputReader) {
        return new ListCluesCommand();
    }

    /**
     * Crea un comando para actualizar pistas.
     */
    public static UpdateClueCommand createUpdateClueCommand(InputReader inputReader) {
        return new UpdateClueCommand();
    }

    /**
     * Crea un comando para eliminar pistas.
     */
    public static DeleteClueCommand createDeleteClueCommand(InputReader inputReader) {
        return new DeleteClueCommand();
    }
}
