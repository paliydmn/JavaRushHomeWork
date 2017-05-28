package com.javarush.test.level21.lesson16.big01;

import java.util.Random;

/**
 * Created by Dima on 27.06.2016.
 */
public class Horse
{
    String name;
    double speed;
    double distance;
    int endurance;

    public int getEndurance()
    {
        return endurance;
    }

    public void setEndurance(int endurance)
    {
        this.endurance = endurance;
    }

    public Horse(String name, double speed, double distance, int endurance )
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        this.endurance = endurance;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move(){
        double randSpeed = Math.random();
        Random rnd = new Random(endurance);
        if(distance >= 100)
            distance += randSpeed*speed + (rnd.nextDouble()+ endurance);
        else
        distance += randSpeed*speed;

        setDistance(distance);
    }
    public void print(){

        for (int i = 0; i < Math.round(distance); i++ )
        System.out.print(".");
        System.out.println(getName());
       // System.out.println("<- лошадь " + this.getName() );

    }
}
