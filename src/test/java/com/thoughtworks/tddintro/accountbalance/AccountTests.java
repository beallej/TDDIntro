package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTests {

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        int oldBalance = 100;
        Account account = new Account(oldBalance);
        assertEquals(account.deposit(50), oldBalance + 50);

    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        int oldBalance = 100;
        Account account = new Account(oldBalance);
        assertEquals(account.withdraw(50), oldBalance - 50);


    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        int oldBalance = 50;
        Account account = new Account(oldBalance);
        assertEquals(account.withdraw(100),oldBalance);

    }
}
