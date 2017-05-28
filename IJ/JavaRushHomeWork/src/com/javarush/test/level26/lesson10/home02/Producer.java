package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dima on 23.09.2016.
 */
public class Producer implements Runnable
{
    ConcurrentHashMap<String, String> map;

    int i = 1;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try
        {

            while (true)
            {
                System.out.println(String.format("Some text for %s",i ));
                i++;
                Thread.sleep(500);
            }
        }
        catch (InterruptedException ie)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getState()));
        }

    }
}
