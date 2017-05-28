package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


interface Command
{
    void execute() throws InterruptOperationException;
}

/*
package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

*/
/**
 * Created by Dima on 06.10.2016.
 *//*

 interface Command
{
    public void execute() throws InterruptOperationException, NotEnoughMoneyException;

}
*/
