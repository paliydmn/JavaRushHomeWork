package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 28.04.2014.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static void printExitMessage()
    {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = reader.readLine();
            if (message.equalsIgnoreCase(res.getString("operation.EXIT")))
                throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String test;
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));

        }
        test = test.toUpperCase();
        return test;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage(res.getString("invalid.data"));
        }

    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }
}

/*
package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

*/
/**
 * Created by Dima on 03.10.2016.
 *//*

public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static  void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String line = null;
        try
        {
            line = reader.readLine();
            if(line.equalsIgnoreCase("exit"))
            {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e)
        {
        }
        return line;
    }

    */
/*
    2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Если данные валидны, то перевести код в верхний регистр и вернуть.

     *//*

    public static String askCurrencyCode() throws InterruptOperationException
    {
        System.out.println("Please, enter a currency code: ");
        String code = null;
        boolean isContinue = true;
        try
        {
            while (isContinue)
            {
                code = readString();

                if(code.length() == 3)
                {
                    char[] chars = code.toCharArray();
                    for (char c : chars)
                    {
                            if(!Character.isLetter(c))
                            {
                                isContinue = true;
                                System.out.println("The code is not correct. Please, try again: ");
                                break;
                            }
                        isContinue = false;
                    }
                }else
                {
                    System.out.println("The code is not correct. Please, try again: ");
                }
            }
        }
        catch (Exception e)
        {
        }
        return code.toUpperCase();
    }

    */
/*
    3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
Этот метод должен предлагать пользователю ввести два целых положительных числа.
Первое число - номинал, второе - количество банкнот.
Никаких валидаторов на номинал нет. Т.е. 1200 - это нормальный номинал.
Если данные некорректны, то сообщить об этом пользователю и повторить.
Пример вводимых данных:
200 5
     *//*

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        int denomination;
        int amount;

        String[] twoDigits = new String[2];
        String line = null;
        System.out.println("Please, enter two positive integers: ");

        try
        {

            boolean isCorrent = false;
            while (!isCorrent)
            {
                line  = readString();
                if(line.split(" ").length == 2)
                {
                    char[] chars = line.replaceAll(" ","").toCharArray();
                    for (char c : chars)
                    {
                        if(Character.isLetter(c))
                        {
                            System.out.println("The entered data is not correct. Please, try again: ");
                            isCorrent = false;
                            break;
                        }
                        isCorrent = true;
                    }
                }
                else
                {
                    System.out.println("The entered data is not correct. Please, try again: ");
                }
            }
            twoDigits[0] = line.split(" ")[0];
            twoDigits[1] = line.split(" ")[1];
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       return twoDigits;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        System.out.println("Please Enter the # of required operation: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT : ");

        Operation operation = null;
        String str = readString();;

        while (!isDigit(str))
        {
            System.out.println("It is not a number, please try again: ");
            str = readString();
        }

            try
            {
               int operationN = Integer.parseInt(str);
                operation = Operation.getAllowableOperationByOrdinal(operationN);
            }
            catch (Exception e)
            {
            }


        return operation;
    }

    public static String exitYN()
    {
        String exit = null;
        try
        {
            exit = readString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return exit;

    }

    public static boolean isDigit(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static int getSum() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Please enter required sum: ");
         String str = readString();

        while (!isDigit(str))
        {
            ConsoleHelper.writeMessage("Please, enter correct data (required sum): ");
            str = readString();
        }
        return Integer.parseInt(str);
    }
}
*/
