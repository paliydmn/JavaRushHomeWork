package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Dima on 18.02.2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }



    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
