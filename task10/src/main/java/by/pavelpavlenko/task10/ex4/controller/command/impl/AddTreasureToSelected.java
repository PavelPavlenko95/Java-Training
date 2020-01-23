package by.pavelpavlenko.task10.ex4.controller.command.impl;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;

import java.util.ArrayList;

public class AddTreasureToSelected implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String errorMsg = "Не удалось добавить сокровище!";
        String successMsg = "Сокровище добавлено в выбранные сокровища!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 3) {
            return errorMsg;
        }

        try {
            service.addTreasureToSelected(params, dragonTreasure);
            response = successMsg;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}