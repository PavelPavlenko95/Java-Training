package by.pavelpavlenko.task10.ex2.controller.command.impl;

import by.pavelpavlenko.task10.ex2.controller.command.Command;
import by.pavelpavlenko.task10.ex2.entity.Payment;
import by.pavelpavlenko.task10.ex2.service.Service;

public class MakePayment implements Command {
    @Override
    public String execute(String request, Payment payment) {
        Service service = new Service();
        String response = "";

        try {
            response = service.makePayment(payment);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            response = ex.getMessage();
        }

        return response;
    }
}