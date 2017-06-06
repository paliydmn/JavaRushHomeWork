package com.dima.tests.CompareTests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Dima on 28.09.2016.
 */
public class CompareTests
{

    public static void main(String[] args) throws ParseException
    {
        List<Human> humanList = new ArrayList<Human>();

        SimpleDateFormat format = new SimpleDateFormat("MM,dd,yyy", Locale.ENGLISH);

        humanList.add(new Human(22, "abv", format.parse("02,02,1991")));
        humanList.add(new Human(24, "bv", format.parse("02,02,1992")));
        humanList.add(new Human(20, "v", format.parse("06,12,1998")));
        humanList.add(new Human(23, "asb", format.parse("05,15,1991")));
        humanList.add(new Human(21, "aab", format.parse("01,08,1991")));

        int years = ((int) ((new Date().getTime() - format.parse("08,18,1990").getTime()) / 1000 / 60 / 60 / 24 / 365));

        System.out.println(years);
        humanList.add(new Human(years, "Dima", format.parse("08,18,1990")));
/*
        Comparator<Human>  byName = new Comparator<Human>()
        {
            @Override
            public int compare(Human o1, Human o2)
            {
                return o1.name.compareTo(o2.name);
            }
        };*/

     /*   Comparator<Human> byDate = new Comparator<Human>()
        {
            @Override
            public int compare(Human o1, Human o2)
            {
                return o1.someDate.compareTo(o2.someDate);
            }
        };*/

        // Collections.sort(humanList,);

        Comparator<Human> byName = new Human();
        Collections.sort(humanList, byName);

        for (Human h : humanList)
        {
            System.out.println(h.toString());
        }
    }
  /*  public static class Human
    {
        public int age;
        public String name;

        public Date  someDate;

        public Human(int age, String name, Date date)
        {
            this.age = age;
            this.name = name;
            this.someDate = date;
        }*/

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

      /*  @Override
        public String toString()
        {
            String s = age + " " + name + someDate.toString();
            return  s;
        }*/
/*

        @Override
        public int compare(Human o1, Human o2)
        {
            return o1.name.compareTo(o2.name);
        }
*/
}
