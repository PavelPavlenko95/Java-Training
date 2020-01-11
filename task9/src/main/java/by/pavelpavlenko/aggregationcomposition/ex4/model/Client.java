package by.pavelpavlenko.aggregationcomposition.ex4.model;

import java.util.ArrayList;

public class Client {
    private int clientId;
    private ArrayList<BankAccount> accounts;

    Client(int clientId) {
        this.clientId = clientId;
        accounts = new ArrayList<BankAccount>();
    }

    public Client() {
        clientId = 0;
        accounts = new ArrayList<BankAccount>();
    }

    void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void blockAccount(int number) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                account.setBlocked();
                break;
            }
        }
    }

    public void unblockAccount(int number) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                account.setUnblocked();
                break;
            }
        }
    }

    public void addMoney(int number, double amount) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                account.addMoney(amount);
                break;
            }
        }
    }

    public void withdrawMoney(int number, double amount) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                account.withdrawMoney(amount);
                break;
            }
        }
    }

    public int getID() {
        return clientId;
    }
}

