package by.pavelpavlenko.task10.ex4.controller.command.impl;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;

public class SetAvailablePrice implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();
        String response = "";

        String successMsg = "Задана доступная сумма";

        try {
            service.setPriceAvailable(Double.parseDouble(service.parseRequest(request).get(0)), dragonTreasure);
            response = successMsg;
        } catch (Exception ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
