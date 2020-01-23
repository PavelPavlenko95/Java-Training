package by.pavelpavlenko.task10.ex4.controller.command;

import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;

public interface Command {
    String execute(String request, DragonTreasure dragonTreasure);
}