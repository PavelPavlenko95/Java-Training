package by.pavelpavlenko.task10.ex4.controller.command.impl;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, DragonTreasure dragonTreasure) {
        return "Ошибка выполнения команды!";
    }
}
