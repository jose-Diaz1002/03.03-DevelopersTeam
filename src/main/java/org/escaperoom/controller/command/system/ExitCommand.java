package org.escaperoom.controller.command.system;

import org.escaperoom.controller.command.interficie.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("🔚 Saliendo del sistema. ¡Gracias por usar Escape Room!");
        System.exit(0);
    }
}
