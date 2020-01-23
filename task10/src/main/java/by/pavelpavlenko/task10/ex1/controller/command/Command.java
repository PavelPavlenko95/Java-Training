package by.pavelpavlenko.task10.ex1.controller.command;

import by.pavelpavlenko.task10.ex1.entity.TextFile;

public interface Command {
    public String execute(String request, TextFile file);
}
