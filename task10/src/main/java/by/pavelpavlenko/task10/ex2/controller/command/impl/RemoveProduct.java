package by.pavelpavlenko.task10.ex2.controller.command.impl;

import by.pavelpavlenko.task10.ex2.controller.command.Command;
import by.pavelpavlenko.task10.ex2.entity.Payment;
import by.pavelpavlenko.task10.ex2.service.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RemoveProduct implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        String errorMsg = "Не удалось удалить товар!";

        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 1) {
            return errorMsg;
        }

        try {
            service.removeProductFromProducts(params, payment);
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}