package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;

public class CreateClueCommand implements Command {

    private final ClueService clueService;

    public CreateClueCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {


    }
}
