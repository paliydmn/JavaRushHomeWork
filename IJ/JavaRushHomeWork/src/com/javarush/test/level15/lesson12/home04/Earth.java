package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Dima on 25.02.2016.
 */
public class Earth implements Planet
{
    private static Earth instance;
    private Earth(){}

    public static Earth getInstance()
    {
        if (instance == null)
        {
            instance = new Earth();
        }

        return instance;
    }
}
