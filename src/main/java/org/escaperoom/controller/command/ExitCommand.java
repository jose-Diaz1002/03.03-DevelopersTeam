package org.escaperoom.controller.command;

import org.escaperoom.controller.command.interficie.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
        System.exit(0);
    }
}
