package by.pavelpavlenko.aggregationcomposition.ex4.model;

import java.util.*;

public class Bank {
    private ArrayList<Client> clients;
    private ArrayList<BankAccount> accounts;
    private Map<Integer, Integer> map;

    public Bank() {
        map = new HashMap<Integer, Integer>();
        accounts = new ArrayList<BankAccount>();
        clients = new ArrayList<Client>();
    }

    public int addClient() {
        Client client = new Client(clients.size() + 1);

        clients.add(client);
        return clients.size();
    }

    public int addAccount(int ID) {
        BankAccount account = new BankAccount(accounts.size() + 1);

        accounts.add(account);

        for (int i = 0; i < clients.size(); ++i) {
            if (clients.get(i).getID() == ID) {
                clients.get(i).addAccount(account);
                map.put(account.getNumber(), ID);
                break;
            }
        }
        return accounts.size();
    }

    public void blockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (accounts.get(i).isBlocked()) {
                    return;
                }
                accounts.get(i).setBlocked();
                break;
            }
        }
    }

    public void unblockAccount(int number) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).isBlocked()) {
                    return;
                }
                accounts.get(i).setUnblocked();
                break;
            }
        }
    }

    public boolean addMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).addMoney(amount)) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public boolean withdrawMoney(int number, double amount) {
        for (int i = 0; i < accounts.size(); ++i) {
            if (accounts.get(i).getNumber() == number) {
                if (!accounts.get(i).withdrawMoney(amount)) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public double[] findAccount(int number) {
        double[] response = null;

        for (BankAccount account : accounts) {
            if (account.getNumber() == number) {
                response = new double[2];
                response[0] = number + 0.0;
                response[1] = account.getValue();
                break;
            }
        }
        return response;
    }

    public void sortAccounts() {
        Collections.sort(accounts, BankAccount.COMPARE_BY_VALUE);
    }

    public double sumAccounts() {
        double sum = 0;

        for (BankAccount account : accounts) {
            sum += account.getValue();
        }

        return sum;
    }

    public double positiveAccountsSum() {
        double sum = 0;

        for (BankAccount account : accounts) {
            if (account.getValue() > 0) {
                sum += account.getValue();
            }
        }

        return sum;
    }

    public double negativeAccountsSum() {
        double sum = 0;

        for (BankAccount account : accounts) {
            if (account.getValue() < 0) {
                sum += account.getValue();
            }
        }

        return sum;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}

