package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

/**
 * Created by Alex on 29.04.2014.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            ConsoleHelper.writeMessage(res.getString("before"));
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try
            {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currencyCode));
            break;
        }

    }
}
/*
package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

*/
/**
 * Created by Dima on 06.10.2016.
 *//*

class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException, NotEnoughMoneyException
    {
        String currenceCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currenceCode);
        boolean isContinue = true;

       // Map<Integer, Integer> withdrawMap = null;


        int withdraw = 0;
        while (true)
        {
            System.out.println("Введите сумму:");
            try{
                withdraw = Integer.parseInt(ConsoleHelper.readString());
                if (withdraw <= 0) throw new NumberFormatException();
                if (!manipulator.isAmountAvailable(withdraw)) throw new NotEnoughMoneyException();
                Map<Integer, Integer> withdrawMap = manipulator.withdrawAmount(withdraw);
                for (Map.Entry<Integer, Integer> entry : withdrawMap.entrySet())
                    System.out.println("\t" + entry.getKey() + " - " + entry.getValue());
                System.out.println("Транзакция успешно завершена");
                break;
            }
            catch (NotEnoughMoneyException e)
            {
                System.out.println("Недостаточно денег");
            }
            catch (NumberFormatException e){
                System.out.println("Неверный формат");
            }
        }


*/
/*

        while (isContinue)
        {
            int sum = Integer.parseInt(ConsoleHelper.readString());

            try
            {
                    if(sum > 0 && manipulator.isAmountAvailable(sum))
                    {
                        withdrawMap = manipulator.withdrawAmount(sum);
                        isContinue = false;
                    }
                    else
                        throw new NotEnoughMoneyException();

            }
            catch (NotEnoughMoneyException e)
            {
                if(!manipulator.hasMoney())
                    isContinue = false;
                else
                    ConsoleHelper.writeMessage("уведомить юзера о нехватке банкнот и вернуться 1.3");
            }
            catch (NumberFormatException e){
                System.out.println("Неверный формат");
            }
        }
        if(manipulator.hasMoney() && !isContinue)
        ConsoleHelper.writeMessage("Success! ");

        for (Map.Entry<Integer, Integer> map : withdrawMap.entrySet())
        {
            System.out.println("    " + map.getKey() + "  -  " + map.getValue());
        }
*//*


    }
}
*/
