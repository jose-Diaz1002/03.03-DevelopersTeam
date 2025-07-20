package org.escaperoom.factory;

import org.escaperoom.controller.command.clue.DeleteClueCommand;
import org.escaperoom.controller.command.clue.ListCluesCommand;
import org.escaperoom.controller.command.clue.UpdateClueCommand;
import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputReader;

import java.sql.SQLException;


public class ClueServiceFactory {


    private ClueServiceFactory() {
    }


    public static ClueService create() {
        try {
            return new ClueService(
                    new MySQLClueDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al crear ClueService: " + e.getMessage(), e);
        }
    }


    public static ListCluesCommand createListCluesCommand(InputReader inputReader) {
        return new ListCluesCommand();
    }


    public static UpdateClueCommand createUpdateClueCommand(InputReader inputReader) {
        return new UpdateClueCommand();
    }


    public static DeleteClueCommand createDeleteClueCommand(InputReader inputReader) {
        return new DeleteClueCommand();
    }
}
