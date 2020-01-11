package by.pavelpavlenko.aggregationcomposition.ex4.model;

import java.util.Comparator;

public class BankAccount {
    private int number;
    private double value;
    private boolean isBlocked;

    public BankAccount(int number, double value) {
        this.number = number;
        this.value = value;
        isBlocked = false;
    }

    BankAccount(int number) {
        this.number = number;
        value = 0.0;
        isBlocked = false;
    }

    public BankAccount() {
        number = 0;
        value = 0.0;
        isBlocked = false;
    }

    boolean addMoney(double amount) {
        if (!isBlocked) {
            value += amount;
            return true;
        } else {
            return false;
        }
    }

    boolean withdrawMoney(double amount) {
        if (!isBlocked) {
            value -= amount;
            return true;
        } else {
            return false;
        }
    }

    void setBlocked() {
        isBlocked = true;
    }

    void setUnblocked() {
        isBlocked = false;
    }

    public int getNumber() {
        return number;
    }

    public double getValue() {
        return value;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    static final Comparator<BankAccount> COMPARE_BY_VALUE = new Comparator<BankAccount>() {
        public int compare(BankAccount o1, BankAccount o2) {
            return Double.compare(o1.getValue(), o2.getValue());
        }
    };
}

