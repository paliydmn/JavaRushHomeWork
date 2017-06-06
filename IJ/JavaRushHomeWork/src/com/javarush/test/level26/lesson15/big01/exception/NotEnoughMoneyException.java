package com.javarush.test.level26.lesson15.big01.exception;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;

/**
 * Created by Dima on 03.10.2016.
 */
public class NotEnoughMoneyException extends Exception
{
    public NotEnoughMoneyException()
    {
        ConsoleHelper.writeMessage("No enough money!");
    }
}
