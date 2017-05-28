package com.dima.tests.threads;

/**
 * Created by Dima on 19.08.2016.
 */
public class Account
{
    private int balance;


    public Account(int initialBalance)
    {
        this.balance = initialBalance;
    }
    public void withdraw(int amount)
    {
        balance -= amount;
    }

    public void deposit(int amount)
    {
        balance += amount;
    }

    public int getBalance()
    {
        return balance;
    }
    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException
    {
      /*  if(acc1.getBalance() < amount)
            throw  new InsufficientFundsException();*/


        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
