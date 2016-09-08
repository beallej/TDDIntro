package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by josiebealle on 08/09/2016.
 */
public class Account {

    private int balance;

    public Account(int startBalance) {
        balance = startBalance;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) {
        if (amount < balance){
            balance -= amount;
        }
        return balance;
    }
}
