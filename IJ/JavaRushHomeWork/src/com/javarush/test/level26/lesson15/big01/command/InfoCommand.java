package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by Alex on 29.04.2014.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute()
    {
        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if (cur.hasMoney()){
                if (cur.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
/*
package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;

*/
/**
 * Created by Dima on 06.10.2016.
 *//*

class InfoCommand implements Command
{
    @Override
    public void execute()throws InterruptOperationException
    {
       Collection<CurrencyManipulator> currencyManipulator = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        if(!currencyManipulator.isEmpty())
        {
            for (CurrencyManipulator manipulator : currencyManipulator)
            {
                if(manipulator.hasMoney() && (manipulator.getTotalAmount() >0))
                {
                   ConsoleHelper.writeMessage( " " + manipulator.getTotalAmount() + " - " + manipulator.getCurrencyCode());
                }
                else
                    ConsoleHelper.writeMessage("No money available.");
            }
        }
        else
            ConsoleHelper.writeMessage("No money available.");

   }
}
*/
