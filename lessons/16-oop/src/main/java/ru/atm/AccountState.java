package ru.atm;

public class AccountState {
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void printState() {
        System.out.println("Your balance: " + amount);
    }
}
