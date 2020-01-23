package by.pavelpavlenko.task10.ex2.controller.command.impl;

import by.pavelpavlenko.task10.ex2.controller.command.Command;
import by.pavelpavlenko.task10.ex2.entity.Payment;
import by.pavelpavlenko.task10.ex2.service.Service;

import java.util.ArrayList;

public class AddProductAvailable implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        String errorMsg = "Не удалось добавить товар!";
        String successMsg = "Товар добавлен успешно!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 4) {
            return errorMsg;
        }

        try {
            service.addProductToProductsList(params, payment);
            response = successMsg;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}
