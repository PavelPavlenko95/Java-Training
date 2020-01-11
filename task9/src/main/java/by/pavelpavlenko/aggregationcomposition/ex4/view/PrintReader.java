package by.pavelpavlenko.aggregationcomposition.ex4.view;

import by.pavelpavlenko.aggregationcomposition.ex4.model.BankAccount;
import by.pavelpavlenko.aggregationcomposition.ex4.model.Client;
import java.util.List;
import java.util.Scanner;

public class PrintReader {
    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант:");
        System.out.println("1 - добивать клиента");
        System.out.println("2 - добавить счёт");
        System.out.println("3 - заблокировать счёт");
        System.out.println("4 - разблокировать счёт");
        System.out.println("5 - пополнить счёт");
        System.out.println("6 - снять со счёта");
        System.out.println("7 - поиск счёта");
        System.out.println("8 - сортировка счетов");
        System.out.println("9 - сумма по счетам");
        System.out.println("10 - сумма по положительным счетам");
        System.out.println("11 - сумма по отрицательным счетам");
        System.out.println("12 - просмотр информации по счетам");
        System.out.println("0 - выход");
        System.out.println();

        return scanner.nextInt();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAccList(List<BankAccount> list) {
        for (BankAccount bankAccount : list) {
            System.out.println(bankAccount.getNumber());
        }
    }

    public void printClientList(List<Client> list) {
        for (Client client : list) {
            System.out.println(client.getID());
        }
    }

    public int scanSingleChoice() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public double scanValueDouble() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextDouble();
    }

    public void showAccountsInfo(List<BankAccount> list) {
        for (BankAccount bankAccount : list) {
            System.out.println("Номер счёта: " + bankAccount.getNumber());
            System.out.println("Баланс = " + bankAccount.getValue());
            System.out.println("Статус - " + (bankAccount.isBlocked() ? "заблокирован" : "разблокирован"));
        }
    }

}

