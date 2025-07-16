package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;


public class AddDecorationObjectCommand implements Command {
    @Override
    public void execute() {

    }/*

    private final DecorationObjectService decorationObjectService;
    private final InputReader inputReader;

    public AddDecorationObjectCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.decorationObjectService = new DecorationObjectService(new MySQLDecorationObjectDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener conexión a la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int roomId = Integer.parseInt(inputReader.readLine("ID de la sala para añadir el objeto decorativo: ").trim());

            String name = inputReader.readLine("Nombre del objeto decorativo: ").trim();
            if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
                return;
            }


            System.out.print("Tipo de decoración: ");
            String decorationType = scanner.nextLine().trim();
            if (decorationType.isEmpty()) {
                System.out.println("El tipo de decoración no puede estar vacío.");
                return;
            }

            String materialType = inputReader.readLine("Tipo de material: ").trim();

            BigDecimal price;
            try {
                price = new BigDecimal(inputReader.readLine("Precio del objeto decorativo: ").trim());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido.");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(inputReader.readLine("Cantidad disponible: ").trim());
                if (quantity < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida.");
                return;
            }

            DecorationObject decorationObject = new DecorationObject(roomId, name, materialType, price, quantity);
            decorationObjectService.addDecorationObject(decorationObject);



            System.out.println("Objeto decorativo añadido correctamente.");


        } catch (DecorationObjectCreationException e) {
            System.out.println("Error al añadir objeto decorativo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }*/
}
