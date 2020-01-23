package by.pavelpavlenko.task10.ex2.controller.command;

import by.pavelpavlenko.task10.ex2.entity.Payment;

public interface Command {
    public String execute(String request, Payment payment);
}