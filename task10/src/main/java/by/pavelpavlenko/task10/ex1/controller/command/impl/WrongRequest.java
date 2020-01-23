package by.pavelpavlenko.task10.ex1.controller.command.impl;

import by.pavelpavlenko.task10.ex1.controller.command.Command;
import by.pavelpavlenko.task10.ex1.entity.TextFile;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, TextFile file) {
        return "Ошибка выполнения команды!";
    }
}
