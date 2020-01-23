package by.pavelpavlenko.task10.ex2.controller.command.impl;

import by.pavelpavlenko.task10.ex2.controller.command.Command;
import by.pavelpavlenko.task10.ex2.entity.Payment;

public class WrongRequest implements Command {
    @Override
    public String execute(String request, Payment payment) {
        return "Ошибка выполнения команды!";
    }
}
