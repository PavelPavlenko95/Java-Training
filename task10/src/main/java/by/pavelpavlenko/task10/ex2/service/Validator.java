package by.pavelpavlenko.task10.ex2.service;

import by.pavelpavlenko.task10.ex2.entity.Payment;

import java.util.ArrayList;

public class Validator {
    public boolean checkIsProductExists(String name, Payment payment) {
        ArrayList<Payment.Product> products = new ArrayList<>(payment.getProductsList());

        for (int i = 0; i < products.size(); ++i) {
            if (products.get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIsAmountEnough(Payment.Product productAvailable, double amountToBuy) {
        return productAvailable.getAmount() >= amountToBuy;
    }
}