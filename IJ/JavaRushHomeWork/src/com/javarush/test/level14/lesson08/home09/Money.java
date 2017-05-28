package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double dMoney;
    public Money(double amount)
    {
        this.dMoney = amount;
    }

    public double getAmount()
    {
        return dMoney;
    }

    public abstract String getCurrencyName();
}

