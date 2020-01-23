package by.pavelpavlenko.task10.ex4.controller;

import by.pavelpavlenko.task10.ex4.controller.command.Command;
import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;
import by.pavelpavlenko.task10.ex4.view.PrintReader;

public class Runner {
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public static void main(String[] args) {
        Runner runner = new Runner();
        PrintReader printReader = new PrintReader();
        DragonTreasure dragonTreasure = new DragonTreasure();
        Service service = new Service();
        String filename = "products.txt";

        String request = "";

        while (!request.equals("exit")) {
            printReader.printMenu();
            request = printReader.scanRequest();

            if (!request.equals("exit")) {
                printReader.printResponse(runner.executeTask(request, dragonTreasure));
            }
        }

        printReader.printResponse("Выход из программы");
    }

    public String executeTask(String request, DragonTreasure dragonTreasure) {
        String commandName;
        Command executionCommand;
        String errorMsg = "Ошибка передачи параметров!";

        String response;

        int index = request.indexOf(paramDelimeter);

        if (index == -1) { // если команда без параметров
            commandName = request;
            executionCommand = provider.getCommand(commandName);
            request = "";
            response = executionCommand.execute(request, dragonTreasure);
        } else {  // команда с параметрами
            commandName = request.substring(0, index);
            executionCommand = provider.getCommand(commandName);

            if (request.length() > index + 1) {
                request = request.substring(index + 1);
                response = executionCommand.execute(request, dragonTreasure);
            } else {
                response = errorMsg;
            }
        }

        return response;
    }
}