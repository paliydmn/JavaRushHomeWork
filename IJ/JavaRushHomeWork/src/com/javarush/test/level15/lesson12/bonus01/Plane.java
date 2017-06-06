package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Dima on 02.03.2016.
 */
public class Plane implements Flyable
{
    int passenger;

    public Plane(int passenger)
    {
        this.passenger = passenger;
        System.out.println("It is a Plane and can get up to = " + passenger + " passenger");
    }

    @Override
    public void fly()
    {

    }
}
