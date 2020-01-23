package by.pavelpavlenko.task10.ex4.controller.command.impl;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;

import java.io.FileNotFoundException;

public class WriteTreasuresToFile implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String successMsg = "Данные записаны в файл";

        try {
            String filename = service.parseRequest(request).get(0);

            if (filename.equals("")) {
                throw new FileNotFoundException("Пустое название файла!");
            }

            service.writeTreasuresToFile(filename, dragonTreasure.getTreasures()); // записываем данные в файл
            response = successMsg;

        } catch (Exception ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}