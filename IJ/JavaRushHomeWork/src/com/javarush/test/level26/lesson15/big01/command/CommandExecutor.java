package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor
{
    private static Map<Operation, Command> map = new HashMap<>();
    static
    {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }

    public CommandExecutor()
    {
    }

}

/*
package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by Dima on 06.10.2016.
 *//*

public class CommandExecutor
{
    private CommandExecutor()
    {
    }

    private static Map<Operation, Command> operationCommandMap;

    static
    {
        operationCommandMap =  new HashMap<Operation, Command>();
        operationCommandMap.put(Operation.INFO,new InfoCommand());
        operationCommandMap.put(Operation.DEPOSIT,new DepositCommand());
        operationCommandMap.put(Operation.WITHDRAW,new WithdrawCommand());
        operationCommandMap.put(Operation.EXIT,new ExitCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException, NotEnoughMoneyException
    {
       operationCommandMap.get(operation).execute();

    }
}
*/
