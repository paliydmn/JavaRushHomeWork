package com.dima.tests.CompareTests;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Dima on 28.09.2016.
 */
public class Human implements /*Comparable<Human>,*/ Comparator<Human>
{
    public int age;
    public String name;
    public Date someDate;
    public Human(){
        super();
    }

    public Human(int age, String name, Date date)
    {
        super();
        this.someDate = date;
        this.age = age;
        this.name = name;
    }

    /*@Override
    public int compareTo(Human o)
    {
        int result = this.age - o.age;
//        System.out.println(result);
        if(result == 0)
            System.out.println("equals " + this.toString() + "  " + o.toString());
        if(result > 0)
            System.out.println("this is bigger " + this.toString() + "  " + o.toString());
        else
            System.out.println("This is lesser " + this.toString() + "  " + o.toString());

        return result;
    }*/

    @Override
    public String toString()
    {
        String s = age + " " + name+ " " + someDate.toString();
        return  s;
    }



/*
    @Override
    public int compare(Human o1, Human o2)
    {
        return o1.someDate.compareTo(o2.someDate);
    }
*/
  @Override
    public int compare(Human o1, Human o2)
    {
        return o1.age - o2.age;
    }

}