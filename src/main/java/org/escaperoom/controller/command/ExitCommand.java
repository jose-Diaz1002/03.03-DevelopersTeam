package org.escaperoom.controller.command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
        System.exit(0);
    }
}
