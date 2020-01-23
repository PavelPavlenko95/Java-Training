package by.pavelpavlenko.task10.ex4.controller.command.impl;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;

public class EraseSelected implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        Service service = new Service();

        String successMsg = "Список выбранных сокровищ очищен!";

        service.eraseSelected(dragonTreasure);

        return successMsg;
    }
}